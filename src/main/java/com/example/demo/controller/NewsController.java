package com.example.demo.controller;

import com.example.demo.model.NewsModel;
import com.example.demo.service.NewsService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Api(tags = {"1. 사용자"})
@RestController
@RequestMapping(value = "/v2/news")
public class NewsController {

    @Resource(name = "newsService")
    private NewsService newsService;

    @ApiOperation(
        value = "News 목록 조회",
        response = NewsModel.class,
        responseContainer = "List",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(
        value = {
            @ApiResponse(code = 401, message = "권한 없음"),
        }
    )
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NewsModel>> getNewsList(
    ) {

        // NEWS 목록 조회
        List<NewsModel> newsList = newsService.selectNewsList();
        log.info("Describe News List");
        return ResponseEntity.status(HttpStatus.OK).body(newsList);
    }

    @ApiOperation(
        value = "NEWS 정보 조회",
        response = NewsModel.class,
        responseContainer = "Object",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(
        value = {
            @ApiResponse(code = 401, message = "권한 없음"),
        }
    )
    @GetMapping(value = "/{newsNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NewsModel> getUser(
            @ApiParam(value = "사용자 아이디", required = true, defaultValue = "1")
            @PathVariable(name = "newsNo") Integer newsNo
    ) {

        // 사용자 상세 정보 조회
        NewsModel newsDetail = newsService.selectNewsDetail(newsNo);
            log.info("Describe User");
        return ResponseEntity.status(HttpStatus.OK).body(newsDetail);
    }
}
