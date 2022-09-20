package com.ssafy.backend.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 프로젝트 이력 등록 API ([POST] /api/v1/users/project) 요청에 필요한 리퀘스트 바디 정의.
 */
@Getter
@Setter
@ApiModel("UserProjectRegisterPostRequest")
public class UserProjectRegisterPostReq {
    @ApiModelProperty(name = "분야", example = "개발")
    String category;

    @ApiModelProperty(name = "형태", example = "앱")
    String domain;

    @ApiModelProperty(name = "기업명", example = "한국투자공사")
    String companyName;

    @ApiModelProperty(name = "프로젝트명", example = "모바일 가상화 시스템 구축")
    String title;

    @ApiModelProperty(name = "담당업무", example = "앱 개발")
    String content;

    @ApiModelProperty(name = "시작날짜", example = "2020-04-01")
    Date start_date;

    @ApiModelProperty(name = "종료날짜", example = "2020-10-31")
    Date end_date;
}
