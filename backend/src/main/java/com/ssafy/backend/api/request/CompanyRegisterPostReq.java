package com.ssafy.backend.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * 기업 회원가입 API ([POST] /api/v1/companies) 요청에 필요한 리퀘스트 바디 정의.
 */
@Getter
@Setter
@ApiModel("CompanyRegisterPostRequest")
public class CompanyRegisterPostReq {
    @NotBlank
    @ApiModelProperty(name="기업 ID", example="ssafy_company")
    String username;

    @NotBlank
    @ApiModelProperty(name="기업 Password", example="your_password")
    String password;

    @Email
    @ApiModelProperty(name="기업 email", example="company@naver.com")
    String email;

    @NotBlank
    @ApiModelProperty(name="기업 name", example="SAMSUNG")
    String name;

    @NotBlank
    @ApiModelProperty(name="기업 phone", example="010-0000-0000")
    String phone;

    @NotBlank
    @ApiModelProperty(name="기업 MetaMask Account Address", example="address")
    String accountAddress;
}
