package com.ssafy.backend.api.service;

import com.ssafy.backend.api.request.UserProfileFetchReq;
import com.ssafy.backend.api.request.UserProjectRegisterPostReq;
import com.ssafy.backend.api.request.UserRegisterPostReq;
import com.ssafy.backend.api.response.UserProjectCareerRes;
import com.ssafy.backend.db.entity.*;
import com.ssafy.backend.db.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

	private final ProjectCareerRepository projectCareerRepository;

	private final TechRepository techRepository;

	private final ProfileTechRepository profileTechRepository;

	private final ProfileTechRepositorySupport profileTechRepositorySupport;

	private final ProfileRepositorySupport profileRepositorySupport;

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
	public void updateUserProfile(String username, UserProfileFetchReq userProfile) {
		Profile profile = userRepositorySupport.findProfileByUsername(username);

		profile.setTitle(userProfile.getTitle());
		profile.setIntroduce(userProfile.getIntroduce());
		profile.setCreer_period(userProfile.getCreer_period());
		profile.setSkill(userProfile.getSkill());

		profileRepository.save(profile);
	}

	@Override
	public ProjectCareer createProjectCareer(User user, UserProjectRegisterPostReq registerProjectInfo) {
		ProjectCareer projectCareer = new ProjectCareer();

		projectCareer.setCategory(registerProjectInfo.getCategory());
		projectCareer.setDomain(registerProjectInfo.getDomain());
		projectCareer.setSkill(registerProjectInfo.getSkill());
		projectCareer.setCompanyName(registerProjectInfo.getCompanyName());
		projectCareer.setTitle(registerProjectInfo.getTitle());
		projectCareer.setContent(registerProjectInfo.getContent());
		projectCareer.setStart_date(registerProjectInfo.getStart_date());
		projectCareer.setEnd_date(registerProjectInfo.getEnd_date());
		projectCareer.setUser(user);

		return projectCareerRepository.save(projectCareer);
	}

	@Override
	public List<UserProjectCareerRes> getProjectCareerAllList(User user) {
		List<ProjectCareer> projectCareerList = projectCareerRepository.findAllByUser(user);

		List<UserProjectCareerRes> res = new ArrayList<>();

		for (ProjectCareer projectCareer : projectCareerList) {
			res.add(UserProjectCareerRes.of(projectCareer));
		}

		return res;
	}

	@Override
	public void deleteUserProjectCareer(Long projectCareerId) {
		projectCareerRepository.deleteById(projectCareerId);
	}

	@Override
	public Long getResumeIdByUserId(Long userId) {
		Long resume_id = userRepositorySupport.findResumeIdByUserId(userId);
		return resume_id;
	}

	@Override
	public Page<User> getFreelancers(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	public List<User> getFreelancersByTechs(List<String> techList) {
		List<Tech> nlist = new ArrayList<>();
		for(String t : techList){
			Tech temp = techRepository.findById(t).get();
			nlist.add(temp);
		}

		return profileTechRepositorySupport.getFreelancerListByTechs(nlist);
	}

	@Override
	public void createProfiletech(String username, List<String> techList) {

		for(String t : techList){
			ProfileTech temp = new ProfileTech();
			temp.setProfile(userRepositorySupport.findProfileByUsername(username));
			temp.setTech((Tech) techRepository.findById(t).get());
			profileTechRepository.save(temp);
		}
	}

	@Override
	public Profile createProfile(UserProfileFetchReq userProfileFetchReq, User user) {
		Profile profile = Profile.builder()
				.title(userProfileFetchReq.getTitle())
				.introduce(userProfileFetchReq.getIntroduce())
				.creer_period(userProfileFetchReq.getCreer_period())
				.skill(userProfileFetchReq.getSkill())
				.user(user)
				.build();
		return profileRepository.save(profile);
	}
}
