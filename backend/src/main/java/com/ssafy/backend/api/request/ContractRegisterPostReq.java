package com.ssafy.backend.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 계약서 등록 API ([POST] /api/v1/contracts/{projectId}) 요청에 필요한 리퀘스트 바디 정의.
 */
@Getter
@Setter
@ApiModel("ContractRegisterPostRequest")
public class ContractRegisterPostReq {
    @ApiModelProperty(name = "이미지 경로")
    String imgSRC;

    @ApiModelProperty(name = "계약 내용")
    String content;
}
