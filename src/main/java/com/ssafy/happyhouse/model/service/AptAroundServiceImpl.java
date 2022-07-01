package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.Hospital;
import com.ssafy.happyhouse.model.mapper.AptAroundMapper;

@Service
public class AptAroundServiceImpl implements AptAroundService{

	@Autowired
	private AptAroundMapper aptAroundMapper;
	
	@Override
	public List<Hospital> getHospitalByGugun(String sido, String gugun) {
		return aptAroundMapper.getHospitalByGugun(sido, gugun);
	}

}
