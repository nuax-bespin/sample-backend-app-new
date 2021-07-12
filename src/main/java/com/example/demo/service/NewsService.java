package com.example.demo.service;

import com.example.demo.model.NewsModel;

import java.util.List;

public interface NewsService {

    /**
     * NEWS 목록 조회
     * @return
     */
    List<NewsModel> selectNewsList();

    /**
     * NEWS 상세 조회
     * @param newsNo
     * @return
     */
    NewsModel selectNewsDetail(Integer newsNo);
}
