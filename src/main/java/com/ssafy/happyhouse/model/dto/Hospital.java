package com.ssafy.happyhouse.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hospital {
	// 시도
	private String sido;
	// 구군
	private String gugun;
	// 이름
	private String name;
	// 도로명주소
	private String address;
	// 유형 
	private String type;
	// 전화번호
	private String tel;
}
