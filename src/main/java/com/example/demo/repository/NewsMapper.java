package com.example.demo.repository;

import com.example.demo.model.NewsModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewsMapper {

    /**
     * NEWS 목록 조회
     * @return
     */
    List<NewsModel> selectNewsList();

    /**
     * NEWS 상세 조회
     * @param emplyrId
     * @return
     */
    NewsModel selectNewsDetail(Integer emplyrId);
}
