package com.ssafy.backend.api.response;

import com.ssafy.backend.db.entity.Profile;
import com.ssafy.backend.db.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 회원 본인 정보 조회 API ([GET] /api/v1/users/profile) 요청에 대한 응답값 정의.
 */
@Getter
@Setter
@ApiModel("UserProfileResponse")
public class UserProfileRes {
	@ApiModelProperty(name="User Profile Serial ID")
	Long profileId;

	@ApiModelProperty(name="User Serial ID")
	Long userId;

	@ApiModelProperty(name="User ID")
	String username;

	@ApiModelProperty(name="이름")
	String name;

	@ApiModelProperty(name="한줄소개")
	String title;

	@ApiModelProperty(name="소개")
	String introduce;

	@ApiModelProperty(name="경력")
	int creer_period;
	
	public static UserProfileRes of(User user, Profile profile) {
		UserProfileRes res = new UserProfileRes();

		//유저 테이블 ID와 이름 정보
		res.setUserId(user.getUserId());
		res.setUsername(user.getUsername());
		res.setName(user.getName());

		//프로필 테이블 정보
		res.setTitle(profile.getTitle());
		res.setIntroduce(profile.getIntroduce());
		res.setCreer_period(profile.getCreer_period());
		res.setProfileId(profile.getProfileId());

		return res;
	}
}
