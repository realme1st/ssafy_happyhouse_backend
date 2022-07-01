package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.HouseAvgDto;
import com.ssafy.happyhouse.model.dto.HouseInfoDto;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.service.HouseMapService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/map")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class HouseMapController {
	
	private final Logger logger = LoggerFactory.getLogger(HouseMapController.class);

	@Autowired
	private HouseMapService haHouseMapService;
	
	@GetMapping("/sido")
	public ResponseEntity<List<SidoGugunCodeDto>> sido() throws Exception {
		logger.debug("sido : {}", haHouseMapService.getSido());
		return new ResponseEntity<List<SidoGugunCodeDto>>(haHouseMapService.getSido(), HttpStatus.OK);
	}
	
	@GetMapping("/gugun")
	public ResponseEntity<List<SidoGugunCodeDto>> gugun(@RequestParam("sido") String sido) throws Exception {
		return new ResponseEntity<List<SidoGugunCodeDto>>(haHouseMapService.getGugunInSido(sido), HttpStatus.OK);
	}
	
	@GetMapping("/dong")
	public ResponseEntity<List<HouseInfoDto>> dong(@RequestParam("gugun") String gugun) throws Exception {
		return new ResponseEntity<List<HouseInfoDto>>(haHouseMapService.getDongInGugun(gugun), HttpStatus.OK);
	}
	
	@GetMapping("/apt")
	public ResponseEntity<List<HouseInfoDto>> apt(@RequestParam("dong") String dong) throws Exception {
		return new ResponseEntity<List<HouseInfoDto>>(haHouseMapService.getAptInDong(dong), HttpStatus.OK);
	}
	
	@GetMapping("/searchName")
	public ResponseEntity<List<HouseInfoDto>> aptName(@RequestParam("aptName") String aptName) throws Exception {
		return new ResponseEntity<List<HouseInfoDto>>(haHouseMapService.getAptInName(aptName), HttpStatus.OK);
	}
	
	@ApiOperation(value = "구군별 최근거래가격이 비싼 동네순으로 반환한다.", response = List.class)
	@GetMapping("/findAvgDesc/{gugun}")
	public ResponseEntity<List<HouseAvgDto>> findAptAvgDesc(@PathVariable("gugun") String gugun) throws Exception{
		
		return new ResponseEntity<List<HouseAvgDto>>(haHouseMapService.listAptAvgDesc(gugun), HttpStatus.OK);
	}
	@ApiOperation(value = "구군별 최근거래가격이 싼 동네순으로 반환한다.", response = List.class)
	@GetMapping("/findAvgAsc/{gugun}")
	public ResponseEntity<List<HouseAvgDto>> findAptAvgAsc(@PathVariable("gugun") String gugun) throws Exception {
		
		return new ResponseEntity<List<HouseAvgDto>>(haHouseMapService.listAptAvgAsc(gugun), HttpStatus.OK);
	}
	
}
