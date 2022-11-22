package com.ssafy.backend.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 평점 등록 API ([POST] /api/v1/estimates/{username}) 요청에 필요한 리퀘스트 바디 정의.
 */
@Getter
@Setter
@ApiModel("EstimateRegisterPostRequest")
public class EstimateRegisterPostReq {
    @ApiModelProperty(name = "전문성", example = "3.0")
    Float profession;

    @ApiModelProperty(name = "일정준수", example = "4.0")
    Float ontime;

    @ApiModelProperty(name = "적극성", example = "5.0")
    Float active;

    @ApiModelProperty(name = "의사소통", example = "5.0")
    Float communication;

    @ApiModelProperty(name = "재고용 의사", example = "4.0")
    Float reEmployment;
}
