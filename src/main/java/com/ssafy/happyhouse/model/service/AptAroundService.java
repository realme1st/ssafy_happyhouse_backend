package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.Hospital;

public interface AptAroundService {
	List<Hospital> getHospitalByGugun(String sido, String gugun);
}
