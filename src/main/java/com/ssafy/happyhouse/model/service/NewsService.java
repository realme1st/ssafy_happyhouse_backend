package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.component.JsoupComponent;
import com.ssafy.happyhouse.model.dto.NewsDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final JsoupComponent jsoupComponent;

    public List<NewsDto> getNewsList() {
        return jsoupComponent.getNewsList();
    }

	public List<NewsDto> getNewsListS(String search) {
		return jsoupComponent.getNewsListS(search);
	}
}
