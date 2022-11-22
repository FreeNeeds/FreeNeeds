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
	private final ProjectCareerRepositorySupport projectCareerRepositorySupport;
	private final ResumeRepository resumeRepository;
	private final ResumeRepositorySupport resumeRepositorySupport;
	private final EducationRepository educationRepository;
	private final CareerRepository careerRepository;
	private final CertificateRepository certificateRepository;
	private final TechRepository techRepository;
	private final ProfileTechRepository profileTechRepository;
	private final ProfileTechRepositorySupport profileTechRepositorySupport;
	private final ProfileRepositorySupport profileRepositorySupport;
	private final ProjectCareerTechRepository projectCareerTechRepository;

	@Override
	public User createUser(UserRegisterPostReq userRegisterInfo, String publicKey, String privateKey) {
		//중복 확인
		validateDuplicateMember(userRegisterInfo);

		User user = new User();
		user.setUsername(userRegisterInfo.getUsername());
		// 보안을 위해서 유저 패스워드 암호화 하여 디비에 저장.
		user.setPassword(passwordEncoder.encode(userRegisterInfo.getPassword()));
		user.setEmail(userRegisterInfo.getEmail());
		user.setName(userRegisterInfo.getName());
		user.setPhone(userRegisterInfo.getPhone());
		user.setAccountAddress(userRegisterInfo.getAccountAddress());
		user.setPublicKey(publicKey);
		user.setPrivateKey(privateKey);

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

		profileRepository.save(profile);
	}

	@Override
	public ProjectCareer createProjectCareer(User user, UserProjectRegisterPostReq registerProjectInfo) {
		ProjectCareer projectCareer = new ProjectCareer();

		projectCareer.setCategory(registerProjectInfo.getCategory());
		projectCareer.setDomain(registerProjectInfo.getDomain());
		projectCareer.setCompanyName(registerProjectInfo.getCompanyName());
		projectCareer.setTitle(registerProjectInfo.getTitle());
		projectCareer.setContent(registerProjectInfo.getContent());
		projectCareer.setStart_date(registerProjectInfo.getStart_date());
		projectCareer.setEnd_date(registerProjectInfo.getEnd_date());
		projectCareer.setUser(user);

		return projectCareerRepository.save(projectCareer);
	}

	@Override
	public List<UserProjectCareerRes> getProjectCareerAllList(String username) {
		List<ProjectCareer> projectCareerList = projectCareerRepositorySupport.findAllByUsername(username);

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
	public Page<User> getFreelancers(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	public Resume createResume(User user) {
		Resume resume = new Resume();

		resume.setUser(user);
		resumeRepository.save(resume);

		return resume;
	}

	@Override
	public void createEducation(Resume resume, Education education) {
		Education resumeEducation = new Education();

		resumeEducation.setResume(resume);
		resumeEducation.setHighschool(education.getHighschool());
		resumeEducation.setHighschool_start_date(education.getHighschool_start_date());
		resumeEducation.setHighschool_end_date(education.getHighschool_end_date());
		resumeEducation.setUniversity(education.getUniversity());
		resumeEducation.setUniversity_start_date(education.getUniversity_start_date());
		resumeEducation.setUniversity_end_date(education.getUniversity_end_date());
		resumeEducation.setMajor(education.getMajor());

		educationRepository.save(resumeEducation);
	}

	@Override
	public void createCareer(Resume resume, List<Career> careerList) {
		for (Career career : careerList) {
			Career resumeCareer = new Career();

			resumeCareer.setResume(resume);
			resumeCareer.setCompanyName(career.getCompanyName());
			resumeCareer.setDepartment(career.getDepartment());
			resumeCareer.setPosition(career.getPosition());
			resumeCareer.setStart_date(career.getStart_date());
			resumeCareer.setEnd_date(career.getEnd_date());

			careerRepository.save(resumeCareer);
		}
	}

	public List<User> getFreelancersByTechs(List<String> techList) {
		List<Tech> nlist = new ArrayList<>();
		for(String t : techList){
			Tech temp = techRepository.findById(t).get();
			nlist.add(temp);
		}

		return profileTechRepositorySupport.getFreelancerListByTechs(nlist);
	}

	public Page<User> getFreelancersByTechsPaging(List<String> techList, Pageable pageable) {
		List<Tech> nlist = new ArrayList<>();
		for(String t : techList){
			Tech temp = techRepository.findById(t).get();
			nlist.add(temp);
		}

		return profileTechRepositorySupport.getFreelancerListByTechsPaging(nlist,pageable);
	}
	@Override
	public void createProfileTech(String username, List<String> techList) {

		for(String t : techList){
			ProfileTech temp = new ProfileTech();
			temp.setProfile(userRepositorySupport.findProfileByUsername(username));
			temp.setTech((Tech) techRepository.findById(t).get());
			profileTechRepository.save(temp);
		}
	}

	@Override
	public void createCertificate(Resume resume, List<Certificate> certificateList) {
		for (Certificate certificate : certificateList) {
			Certificate resumeCertificate = new Certificate();

			resumeCertificate.setResume(resume);
			resumeCertificate.setDate(certificate.getDate());
			resumeCertificate.setName(certificate.getName());
			resumeCertificate.setCertification(certificate.getCertification());

			certificateRepository.save(resumeCertificate);
		}
	}

	public Profile createProfile(UserProfileFetchReq userProfileFetchReq, User user) {
		Profile profile = Profile.builder()
				.title(userProfileFetchReq.getTitle())
				.introduce(userProfileFetchReq.getIntroduce())
				.creer_period(userProfileFetchReq.getCreer_period())
				.user(user)
				.build();
		return profileRepository.save(profile);
	}

	@Override
	public void createProjectCareerTech(Long projectCareerId, List<String> techList) {
		for(String t : techList){
			ProjectCareerTech temp = new ProjectCareerTech();
//			ProfileTech temp = new ProfileTech();
			temp.setProjectCareer(projectCareerRepository.findProjectCareerByProjectCareerId(projectCareerId));
			temp.setTech((Tech) techRepository.findById(t).get());
//			temp.setProfile(userRepositorySupport.findProfileByUsername(username));
//			temp.setTech((Tech) techRepository.findById(t).get());
			projectCareerTechRepository.save(temp);
		}
	}

	@Override
	public Long getResumeIdByUsername(String username) {
		Long resume_id = resumeRepositorySupport.findResumeIdByUsername(username);

		return resume_id;
	}

	@Override
	public String getUserAccountAddressByUsername(String username) {
		String accountAddress = userRepositorySupport.findUserAccountAddressByUsername(username);
		return accountAddress;
	}

	@Override
	public String getUserAccountAddressByUserId(Long userId) {
		String accountAddress = userRepositorySupport.findUserAccountAddressByUserId(userId);
		return accountAddress;
	}

	@Override
	public String getUsernameByUserId(Long userId) {
		return userRepositorySupport.findUsernameByUserId(userId);
	}

	@Override
	public boolean checkUsernameDuplicate(String username) {
		return userRepository.existsByUsername(username);
	}
}
