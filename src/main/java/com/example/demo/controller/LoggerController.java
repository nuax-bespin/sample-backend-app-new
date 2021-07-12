package com.example.demo.controller;

import com.example.demo.model.NewsModel;
import com.google.common.collect.Maps;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@Api(tags = {"2. Logger"})
@RestController
@RequestMapping(value = "/v2/logger")
public class LoggerController {

    @ApiOperation(
            value = "로그 레벨에 따른 Dummy 로그 생성",
            response = NewsModel.class,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 401, message = "권한 없음"),
            }
    )
    @GetMapping(value = "/{level}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> generateLog(
            @ApiParam(value = "로그 level (debug,error,info)", required = true, defaultValue = "debug")
            @PathVariable(value = "level") String level
    ) {

        Map<String, String> respMap = Maps.newHashMap();
        respMap.put("data", String.format("Current Log Level : %s", level));
        respMap.put("status", "ok");
        switch (level.toLowerCase()){
            case "debug" : log.debug("Hello Debug Log"); break;
            case "error" : log.error("Hello Error Log"); break;
            case "info" : log.info("Hello Info Log"); break;
            default :
                respMap.put("data", String.format("Not Exists Log Level : %s", level));
                respMap.put("status", "false");
        }

        return ResponseEntity.status(HttpStatus.OK).body(respMap);
    }
}
