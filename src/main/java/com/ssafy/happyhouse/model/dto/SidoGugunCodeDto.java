package com.ssafy.happyhouse.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SidoGugunCodeDto {
	private String sidoCode;
	private String sidoName;
	private String gugunCode;
	private String gugunName;
}
