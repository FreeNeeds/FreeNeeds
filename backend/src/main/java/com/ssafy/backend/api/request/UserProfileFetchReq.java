package com.ssafy.backend.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 유저 프로필 수정 API ([PUT] /api/users/profile) 요청에 필요한 리퀘스트 바디 정의.
 */

@Getter
@Setter
@ApiModel("UserProfilePatchReq")
public class UserProfileFetchReq {
    @ApiModelProperty(name="한줄소개")
    String title;

    @ApiModelProperty(name="소개")
    String introduce;

    @ApiModelProperty(name="경력")
    int creer_period;
}
