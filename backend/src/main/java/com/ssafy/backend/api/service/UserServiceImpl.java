package com.ssafy.backend.api.service;

import com.ssafy.backend.api.request.UserProfileFetchReq;
import com.ssafy.backend.api.request.UserRegisterPostReq;
import com.ssafy.backend.db.entity.Profile;
import com.ssafy.backend.db.entity.User;
import com.ssafy.backend.db.repository.ProfileRepository;
import com.ssafy.backend.db.repository.UserRepository;
import com.ssafy.backend.db.repository.UserRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 *	유저 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
 */
@Service("userService")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final UserRepositorySupport userRepositorySupport;
	private final PasswordEncoder passwordEncoder;

	private final ProfileRepository profileRepository;

	@Override
	public User createUser(UserRegisterPostReq userRegisterInfo) {
		//중복 확인
		validateDuplicateMember(userRegisterInfo);

		User user = new User();
		user.setUsername(userRegisterInfo.getUsername());
		// 보안을 위해서 유저 패스워드 암호화 하여 디비에 저장.
		user.setPassword(passwordEncoder.encode(userRegisterInfo.getPassword()));
		user.setEmail(userRegisterInfo.getEmail());
		user.setName(userRegisterInfo.getName());
		user.setPhone(userRegisterInfo.getPhone());

		return userRepository.save(user);
	}

	@Override
	public void validateDuplicateMember(UserRegisterPostReq userRegisterInfo) {
		if (getUserByUsername(userRegisterInfo.getUsername()).orElse(null) != null) {
			throw new IllegalStateException("Please enter a different username.");
		}
	}
	@Override
	public Optional<User> getUserByUsername(String username) {
		// 디비에 유저 정보 조회 (userId 를 통한 조회).
		Optional<User> user = userRepositorySupport.findUserByUsername(username);
		return user;
	}

	@Override
	public Optional<User> getUserByUserId(Long userId) {return userRepository.findById(userId);}

	@Override
	public Profile getProfileByUserId(Long userId) {
		Profile profile = userRepositorySupport.findProfileByUserId(userId);
		return profile;
	}

	@Override
	public void updateUserProfile(Long userId, UserProfileFetchReq userProfile) {
		Profile profile = userRepositorySupport.findProfileByUserId(userId);

		profile.setTitle(userProfile.getTitle());
		profile.setIntroduce(userProfile.getIntroduce());
		profile.setCreer_period(userProfile.getCreer_period());
		profile.setSkill(userProfile.getSkill());

		profileRepository.save(profile);
	}
}
