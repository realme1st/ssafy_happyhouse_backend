package com.ssafy.happyhouse.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.NewsDto;
import com.ssafy.happyhouse.model.service.NewsService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping("/news")
    public List<NewsDto> getNewsList(HttpServletRequest request) {
        return newsService.getNewsList();

    }
    
    @GetMapping("/news/search/{search}")
    public List<NewsDto> getNewsListS(@PathVariable String search) {
    	return newsService.getNewsListS(search);
    }
}
