package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.Hospital;
import com.ssafy.happyhouse.model.service.AptAroundService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/aptaround")
public class AptAroundController {
	
	private static final Logger logger = LoggerFactory.getLogger(AptAroundController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private AptAroundService aptAroundService;
	
	@ApiOperation(value = "병원정보를 반환한다.", response = List.class)
	@GetMapping(value = "/hospital/{sido}/{gugun}")
	public List<Hospital> getAllHospInGugun(@PathVariable("sido") String sido,@PathVariable("gugun") String gugun) throws Exception {
		logger.debug("gethospital - 호출");
		return aptAroundService.getHospitalByGugun(sido, gugun);
	}
	
}
