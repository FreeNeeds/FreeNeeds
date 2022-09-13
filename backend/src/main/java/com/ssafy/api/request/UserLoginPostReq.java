package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

/**
 * 유저 로그인 API ([POST] /api/v1/auth/login) 요청에 필요한 리퀘스트 바디 정의.
 */
@Getter
@Setter
@ApiModel("UserLoginPostRequest")
public class UserLoginPostReq {
	@Size(min = 4,max = 16)
	@ApiModelProperty(name = "유저 ID", example = "ssafy_web")
	String username;

	@Size(min = 9,max = 16)
	@ApiModelProperty(name = "유저 Password", example = "your_password")
	String password;
}
