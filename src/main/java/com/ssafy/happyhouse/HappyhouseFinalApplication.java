package com.ssafy.happyhouse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ssafy.happyhouse.model.repo")
public class HappyhouseFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HappyhouseFinalApplication.class, args);
	}

}
