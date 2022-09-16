package com.ssafy.backend.api.service;

import com.ssafy.backend.api.request.UserProfileFetchReq;
import com.ssafy.backend.api.request.UserProjectRegisterPostReq;
import com.ssafy.backend.api.request.UserRegisterPostReq;
import com.ssafy.backend.api.response.UserProjectCareerRes;
import com.ssafy.backend.db.entity.Profile;
import com.ssafy.backend.db.entity.ProjectCareer;
import com.ssafy.backend.db.entity.User;

import java.util.List;
import java.util.Optional;

/**
 *	유저 관련 비즈니스 로직 처리를 위한 서비스 인터페이스 정의.
 */
public interface UserService {
	User createUser(UserRegisterPostReq userRegisterInfo);
	Optional<User> getUserByUsername(String username);
	void validateDuplicateMember(UserRegisterPostReq userRegisterInfo);

	public Optional<User> getUserByUserId(Long userId);

	Profile getProfileByUserId(Long userId);

	void updateUserProfile(String username, UserProfileFetchReq userProfile);

	ProjectCareer createProjectCareer(User user, UserProjectRegisterPostReq registerProjectInfo);

	List<UserProjectCareerRes> getProjectCareerAllList(User user);
}
