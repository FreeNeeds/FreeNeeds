package com.ssafy.backend.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("CompanyLoginPostRequest")
public class CompanyLoginPostReq {
    @ApiModelProperty(name = "기업 ID", example = "ssafy_web")
    String username;

    @ApiModelProperty(name = "기업 Password", example = "your_password")
    String password;
}
