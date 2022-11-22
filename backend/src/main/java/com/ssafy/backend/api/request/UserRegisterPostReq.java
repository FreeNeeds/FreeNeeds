package com.ssafy.backend.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * 유저 회원가입 API ([POST] /api/v1/users) 요청에 필요한 리퀘스트 바디 정의.
 */
@Getter
@Setter
@ApiModel("UserRegisterPostRequest")
public class UserRegisterPostReq {
	@NotBlank
	@ApiModelProperty(name="유저 ID", example="ssafy_web")
	String username;

	@NotBlank
	@ApiModelProperty(name="유저 Password", example="your_password")
	String password;

	@Email
	@ApiModelProperty(name="유저 email", example="user@naver.com")
	String email;

	@NotBlank
	@ApiModelProperty(name="유저 name", example="name")
	String name;

	@NotBlank
	@ApiModelProperty(name="유저 phone", example="phone")
	String phone;

	@NotBlank
	@ApiModelProperty(name="유저 MetaMask Account Address", example="address")
	String accountAddress;
}
