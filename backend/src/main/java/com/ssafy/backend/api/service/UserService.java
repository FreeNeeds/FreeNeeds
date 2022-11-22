package com.ssafy.backend.api.service;

import com.ssafy.backend.api.request.UserProfileFetchReq;
import com.ssafy.backend.api.request.UserProjectRegisterPostReq;
import com.ssafy.backend.api.request.UserRegisterPostReq;
import com.ssafy.backend.api.response.UserProjectCareerRes;
import com.ssafy.backend.db.entity.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 *	유저 관련 비즈니스 로직 처리를 위한 서비스 인터페이스 정의.
 */
public interface UserService {
	User createUser(UserRegisterPostReq userRegisterInfo, String publicKey, String privateKey);
	Optional<User> getUserByUsername(String username);
	void validateDuplicateMember(UserRegisterPostReq userRegisterInfo);

	public Optional<User> getUserByUserId(Long userId);

	Profile getProfileByUserId(Long userId);

	void updateUserProfile(String username, UserProfileFetchReq userProfile);

	ProjectCareer createProjectCareer(User user, UserProjectRegisterPostReq registerProjectInfo);

	List<UserProjectCareerRes> getProjectCareerAllList(String username);

	void deleteUserProjectCareer(Long projectCareerId);

	Page<User> getFreelancers(Pageable pageable);

	Resume createResume(User user);

	void createEducation(Resume resume, Education education);

	void createCareer(Resume resume, List<Career> careerList);

	void createCertificate(Resume resume, List<Certificate> certificateList);

	List<User> getFreelancersByTechs(List<String> techList);

	Page<User> getFreelancersByTechsPaging(List<String> techList, Pageable pageable);

	void createProfileTech(String username, List<String> techList);

	Profile createProfile(UserProfileFetchReq userProfileFetchReq, User user);

	void createProjectCareerTech(Long projectCareerId, List<String> techList);

    Long getResumeIdByUsername(String username);

    String getUserAccountAddressByUsername(String username);

	String getUserAccountAddressByUserId(Long userId);

	String getUsernameByUserId(Long userId);

	boolean checkUsernameDuplicate(String username);

}
