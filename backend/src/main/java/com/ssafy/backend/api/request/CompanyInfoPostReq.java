package com.ssafy.backend.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ApiModel("CompanyInfoPostRequest")
public class CompanyInfoPostReq {

    @NotBlank
    @ApiModelProperty(name="대표자 이름", example="김싸피")
    private String ceo;

    @NotNull
    @ApiModelProperty(name="회사 주소", example = "서울 서초구 서초대로74길 11")
    private String address;

    @NotBlank
    @ApiModelProperty(name="회사 전화번호", example = "02-569-0000")
    private String companyCall;

    @NotBlank
    @ApiModelProperty(name="사업자등록번호", example = "100-81-23456")
    private String registrationNumber;

    @NotBlank
    @ApiModelProperty(name="사업자등록증", example = "사업자등록증 URL")
    private String registrationFile;
}
