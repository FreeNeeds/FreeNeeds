package com.ssafy.api.service;

import com.ssafy.api.request.UserRegisterPostReq;
import com.ssafy.db.entity.User;

import java.util.Optional;

/**
 *	유저 관련 비즈니스 로직 처리를 위한 서비스 인터페이스 정의.
 */
public interface UserService {
	User createUser(UserRegisterPostReq userRegisterInfo);
	Optional<User> getUserByUsername(String username);
	void validateDuplicateMember(UserRegisterPostReq userRegisterInfo);

	public Optional<User> getUserByUserId(Long userId);
}
