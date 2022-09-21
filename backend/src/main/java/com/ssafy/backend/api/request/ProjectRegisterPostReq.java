package com.ssafy.backend.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 프로젝트 등록 API ([POST] /api/v1/project) 요청에 필요한 리퀘스트 바디 정의.
 */
@Getter
@Setter
@ApiModel("ProjectRegisterPostRequest")
public class ProjectRegisterPostReq {

    @NotBlank
    @ApiModelProperty(name="분야", example="개발")
    private String category;

    @NotBlank
    @ApiModelProperty(name="형태", example="웹사이트")
    private String domain;

    @NotBlank
    @ApiModelProperty(name="지역 시", example="대전광역시")
    private String locationSi;

    @NotBlank
    @ApiModelProperty(name="지역 구", example="유성구")
    private String locationGu;

    @NotBlank
    @ApiModelProperty(name="기술", example="java, javascript, mysql")
    private String skill;

    @NotBlank
    @ApiModelProperty(name="제목", example="AI기반 Firescout 솔루션 ux/ui 디자인")
    private String title;

    @NotBlank
    @ApiModelProperty(name="내용", example="AI기반 Firescout 솔루션 ux/ui 디자인")
    private String content;


    @NotBlank
    @ApiModelProperty(name="시작 일자", example="2022-09-06")
    private Date startDate;

    @NotBlank
    @ApiModelProperty(name="종료 일자", example="2022-09-07")
    private Date endDate;

    @NotBlank
    @ApiModelProperty(name="마감 일자", example="2022-09-05")
    private Date deadline;

    @NotBlank
    @ApiModelProperty(name="모집인원", example="4")
    private int recruitNumber;

    @NotBlank
    @ApiModelProperty(name="담당 업무", example="1) Native UI/UX\n" +
            "2) 단말 내 시스템 연동\n" +
            "3) API 서버 연동\n")
    private String task;

    @NotBlank
    @ApiModelProperty(name="근무 방식", example="재택")
    private String workStyle;

    @NotBlank
    @ApiModelProperty(name="근무 시작 시간", example="오전 08:00")
    private String workStartTime;

    @NotBlank
    @ApiModelProperty(name="근무 종료 시간", example="오후 16:00")
    private String workEndTime;

    @NotBlank
    @ApiModelProperty(name="최저 임금", example="300만원")
    private String lowPrice;

    @NotBlank
    @ApiModelProperty(name="최고 임금", example="협의")
    private String highPrice;

    @NotBlank
    @ApiModelProperty(name="경력 기간", example="13")
    private int careerPeriod;
}
