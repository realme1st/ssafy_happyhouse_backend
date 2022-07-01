package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.User;
import com.ssafy.happyhouse.model.service.JwtService;
import com.ssafy.happyhouse.model.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@Slf4j
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "아이디 체크", notes = "아이디의 중복여부를 검사한다. 아이디가 있으면 'success' 없으면 'fail'을 반환한다.", response = String.class)
	@GetMapping("/idcheck/{userid}")
	public ResponseEntity<String> idCheck(@PathVariable("userid") @ApiParam(value = "검사할 아이디", required = true) String checkId) throws Exception {
		if (userService.idCheck(checkId)) 
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		else
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "회원가입", notes = "회원 정보를 입력받아 회원가입을 진행한다. DB입력에 성공하면 'success' 실패하면 'fail'을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> registerUser(@RequestBody @ApiParam(value = "회원 정보", required = true) User userDto) throws Exception {
		logger.debug("memberDto info : {}", userDto);
		if (userService.registerUser(userDto)) 
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		else 
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "로그인", notes = "Access-token과 로그인 결과 메세지를 반환한다.", response = Map.class)
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody @ApiParam(value = "로그인 시 필요한 회원정보(아이디, 비밀번호).", required = true) User userDto) throws Exception {
		logger.debug("login - 호출 ");
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			User loginUser = userService.login(userDto);
			if (loginUser != null) {
				String token = jwtService.create("userid", loginUser.getId(), "access-token");// key, data, subject
				logger.debug("로그인 토큰정보 : ", token);
				resultMap.put("access-token", token);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("로그인 실패 : ", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@ApiOperation(value = "회원인증", notes = "회원 정보를 담은 Token을 반환한다.", response = Map.class)
	@GetMapping("/{userid}")
	public ResponseEntity<Map<String, Object>> getUserInfo(
			@PathVariable("userid") @ApiParam(value = "인증할 회원의 아이디.", required = true) String userid,
			HttpServletRequest request) {
		logger.debug("userid : ", userid);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		if (jwtService.isUsable(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			try {
//				로그인 사용자 정보.
				User userDto = userService.getUser(userid);
				resultMap.put("userInfo", userDto);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.error("정보조회 실패 : {}", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			logger.error("사용 불가능 토큰!!!");
			resultMap.put("message", FAIL);
			status = HttpStatus.ACCEPTED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@ApiOperation(value = "회원정보 수정", notes = "회원 정보를 입력받아 회원정보 수정을 진행한다. DB입력에 성공하면 'success' 실패하면 'fail'을 반환한다.", response = String.class)
	@PutMapping
	public ResponseEntity<String> modifyUser(@RequestBody @ApiParam(value = "회원 정보", required = true) User userDto) throws Exception {
		logger.debug("modifyUser : ", userDto);
		if (userService.updateUser(userDto)) 
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		else 
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "회원탈퇴", notes = "회원 탈퇴를 진행한다. DB삭제에 성공하면 'success' 실패하면 'fail'을 반환한다.", response = String.class)
	@DeleteMapping
	public ResponseEntity<String> deleteUser(@RequestBody @ApiParam(value = "삭제할 회원 정보 (userId만 필요)", required = false) User userDto) throws Exception {
		logger.debug("deleteUser : ", userDto);
		if (userService.deleteUser(userDto.getId())) 
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		else 
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
}
