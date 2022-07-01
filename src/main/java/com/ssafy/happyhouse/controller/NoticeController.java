package com.ssafy.happyhouse.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.Board;
import com.ssafy.happyhouse.model.dto.Notice;
import com.ssafy.happyhouse.model.service.NoticeService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/notice")
public class NoticeController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private NoticeService noticeService;

    @ApiOperation(value = "모든 게시글의 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<Notice>> retrieveNotice() throws Exception {
		logger.debug("retrieveNotice - 호출");
		return new ResponseEntity<List<Notice>>(noticeService.retrieveNotice(), HttpStatus.OK);
	}

    @ApiOperation(value = "글번호에 해당하는 게시글의 정보를 반환한다.", response = Notice.class)    
	@GetMapping("{articleno}")
	public ResponseEntity<Notice> detailNotice(@PathVariable int articleno) {
		logger.debug("detailNotice - 호출");
		return new ResponseEntity<Notice>(noticeService.detailNotice(articleno), HttpStatus.OK);
	}

    @ApiOperation(value = "새로운 게시글 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> writeNotice(@RequestBody Notice notice) {
		logger.debug("writeNotice - 호출");
		if (noticeService.writeNotice(notice)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

    @ApiOperation(value = "글번호에 해당하는 게시글의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{articleno}")
	public ResponseEntity<String> updateNotice(@RequestBody Notice notice) {
		logger.debug("updateNotice - 호출");
		logger.debug("" + notice);
		
		if (noticeService.updateNotice(notice)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

    @ApiOperation(value = "글번호에 해당하는 게시글의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{articleno}")
	public ResponseEntity<String> deleteNotice(@PathVariable int articleno) {
		logger.debug("deleteNotice - 호출");
		if (noticeService.deleteNotice(articleno)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
    
    @ApiOperation(value = "?subject=글제목 에 해당하는 모든 사용자 정보를 반환한다.", response = Board.class)
    @GetMapping("/searchsubject")
	public ResponseEntity<?> searchBySubject(@RequestParam String subject) {
    	List<Notice> notices = noticeService.searchBySubject(subject);
		if (notices != null && notices.size() > 0) {
			return new ResponseEntity<List<Notice>>(notices, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
    
    @ApiOperation(value = "작성자 에 해당하는 모든 사용자 정보를 반환한다.", response = Board.class)
    @GetMapping("/searchid")
	public ResponseEntity<?> searchById(@RequestParam String id) {
    	List<Notice> notices = noticeService.searchById(id);
		if (notices != null && notices.size() > 0) {
			return new ResponseEntity<List<Notice>>(notices, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
    
    @ApiOperation(value = "글번호에 해당하는 게시글의 조회수를 증가시킨다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("/updatehit/{articleno}")
	public ResponseEntity<String> updateHit(@RequestBody Notice notice) {
		logger.debug("updateHit - 호출");
		logger.debug("" + notice);
		
		if (noticeService.updateHit(notice)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

}
