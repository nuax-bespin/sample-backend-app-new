package com.example.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("newsModel")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "News Model")
public class NewsModel {

    @ApiModelProperty(value = "뉴스 번호", example = "1")
    private String newsNo;

    @ApiModelProperty(value = "제목", example = "제목입니다.")
    private String title;

    @ApiModelProperty(value = "내용", example = "내용입니다.")
    private String content;

    @ApiModelProperty(value = "등록자", example = "홍길동")
    private String registUser;

    @ApiModelProperty(value = "사용 여부", example = "Y")
    private String useAt;

    @ApiModelProperty(value = "등록 일시", example = "2020-07-18 05:11:39.538418")
    private Date registDt;

    @ApiModelProperty(value = "수정 일시", example = "2020-07-18 05:11:39.538418")
    private Date updtDt;
}

