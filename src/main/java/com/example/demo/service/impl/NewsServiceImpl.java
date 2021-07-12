package com.example.demo.service.impl;

import com.example.demo.model.NewsModel;
import com.example.demo.repository.NewsMapper;
import com.example.demo.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("newsService")
public class NewsServiceImpl implements NewsService {

    @Resource(name = "newsMapper")
    private NewsMapper newsMapper;

    @Override
    public List<NewsModel> selectNewsList() {
        return newsMapper.selectNewsList();
    }

    @Override
    public NewsModel selectNewsDetail(Integer newsNo) {
        return newsMapper.selectNewsDetail(newsNo);
    }
}
