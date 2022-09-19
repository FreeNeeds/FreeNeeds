package com.ssafy.backend.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ApiModel("ApplyDeleteRequest")
public class ApplyDeleteReq {
    @NotNull
    @ApiModelProperty(name = "유저 id", example = "2")
    Long userId;

    @NotNull
    @ApiModelProperty(name = "프로젝트 id", example = "1")
    Long projectId;
}
