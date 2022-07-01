package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.dto.Hospital;

@Mapper
public interface AptAroundMapper {
	// 시도, 구군으로 안심병원 가져오기
	public List<Hospital> getHospitalByGugun(String sido, String gugun);
}
