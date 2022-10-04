package com.ssafy.backend.api.controller;

import com.ssafy.backend.api.request.*;
import com.ssafy.backend.api.response.*;
import com.ssafy.backend.api.service.*;
import com.ssafy.backend.common.auth.SsafyUserDetails;
import com.ssafy.backend.common.model.response.BaseResponseBody;
import com.ssafy.backend.common.util.RSAUtil;
import com.ssafy.backend.db.entity.*;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * 유저 관련 API 요청 처리를 위한 컨트롤러 정의.
 */
@Api(value = "유저 API", tags = {"User"})
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	private final EducationService educationService;
	private final CareerService careerService;
	private final CertificateService certificateService;
	private final ProjectCareerService projectCareerService;
	private final ProfileService profileService;



	@PostMapping()
	@ApiOperation(value = "회원 가입", notes = "<strong>아이디와 패스워드</strong>를 통해 회원가입 한다.") 
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "인증 실패"),
        @ApiResponse(code = 404, message = "사용자 없음"),
        @ApiResponse(code = 500, message = "서버 오류")
    })
	public ResponseEntity<? extends BaseResponseBody> register(
			@RequestBody @ApiParam(value="회원가입 정보", required = true)@Validated UserRegisterPostReq registerInfo) throws NoSuchAlgorithmException {
		//RSA 공개키, 개인키 발급
		HashMap<String, String> rsaKeyPair = RSAUtil.createKeypairAsString();
		String publicKey = rsaKeyPair.get("publicKey");
		String privateKey = rsaKeyPair.get("privateKey");
		
		//임의로 리턴된 User 인스턴스. 현재 코드는 회원 가입 성공 여부만 판단하기 때문에 굳이 Insert 된 유저 정보를 응답하지 않음.
		User user = userService.createUser(registerInfo, publicKey, privateKey);
		
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
	@GetMapping("/profile/{username}")
	@ApiOperation(value = "유저 프로필 정보 조회", notes = "로그인한 회원의 프로필 정보를 조회한다.")
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "인증 실패"),
        @ApiResponse(code = 404, message = "사용자 없음"),
        @ApiResponse(code = 500, message = "서버 오류")
    })
	public ResponseEntity<UserProfileRes> getUserProfile(@PathVariable String username) {
		User user = userService.getUserByUsername(username).get();

		//userId로 프로필 테이블에서 일치하는 정보 찾아오기
		Profile profile = userService.getProfileByUserId(user.getUserId());
		
		//찾아온 정보를 UserProfileRes에 담아 값 전달하기
		return ResponseEntity.status(200).body(UserProfileRes.of(user, profile));
	}

	@PatchMapping("/profile")
	@ApiOperation(value = "유저 프로필 수정", notes = "유저 프로필을 수정 후 응답한다")
	@ApiResponses({
			@ApiResponse(code = 200, message = "성공"),
			@ApiResponse(code = 401, message = "실패"),
			@ApiResponse(code = 500, message = "서버 오류")
	})
	public ResponseEntity<? extends BaseResponseBody> updateUserProfile(
			@ApiIgnore Authentication authentication,
			@RequestBody @ApiParam(value = "유저 프로필 정보", required = true) UserProfileFetchReq userProfile) {
		/**
		 * 요청 헤더 액세스 토큰이 포함된 경우에만 실행되는 인증 처리이후, 리턴되는 인증 정보 객체(authentication) 통해서 요청한 유저 식별.
		 * 액세스 토큰이 없이 요청하는 경우, 403 에러({"error": "Forbidden", "message": "Access Denied"}) 발생.
		 */
		SsafyUserDetails userDetails = (SsafyUserDetails)authentication.getDetails();
		String username = userDetails.getUsername();

		userService.updateUserProfile(username, userProfile);

		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}

	@PostMapping("/project")
	@ApiOperation(value = "유저 프로젝트 이력 등록", notes = "유저의 프로젝트 이력을 등록한다. ")
	@ApiResponses({
			@ApiResponse(code = 200, message = "성공"),
			@ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "사용자 없음"),
			@ApiResponse(code = 500, message = "서버 오류")
	})
	public ResponseEntity<Long> registerUserProject(
			@ApiIgnore Authentication authentication,
			@RequestBody @ApiParam(value="프로젝트 이력 정보", required = true) UserProjectRegisterPostReq registerProjectInfo) {
		SsafyUserDetails userDetails = (SsafyUserDetails)authentication.getDetails();
		String userId = userDetails.getUsername();
		User user = userService.getUserByUsername(userId).get();
		
		//userId와 입력된 프로젝트 이력 정보 등록
		ProjectCareer projectCareer = userService.createProjectCareer(user, registerProjectInfo);

		return ResponseEntity.status(200).body(projectCareer.getProjectCareerId());
	}

	@GetMapping("/project/{username}")
	@ApiOperation(value = "유저 프로젝트 이력 조회", notes = "로그인한 회원의 프로젝트 이력을 조회한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "성공"),
			@ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "사용자 없음"),
			@ApiResponse(code = 500, message = "서버 오류")
	})
	public ResponseEntity<List<UserProjectCareerRes>> getUserProjectCareerList(@PathVariable String username) {
		//username(id)로 해당되는 프로젝트 이력 리스트 가져오기
		List<UserProjectCareerRes> res = userService.getProjectCareerAllList(username);

		//찾아온 정보를 UserProfileRes에 담아 값 전달하기
		return ResponseEntity.status(200).body(res);
	}

	@DeleteMapping("/project/{projectCareerId}")
	@ApiOperation(value = "유저 프로젝트 이력 삭제", notes = "로그인한 회원의 프로젝트 이력 중 하나를 삭제한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "성공"),
			@ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "사용자 없음"),
			@ApiResponse(code = 500, message = "서버 오류")
	})
	public ResponseEntity<? extends BaseResponseBody> deleteUserProjectCareer(@PathVariable Long projectCareerId) {
		userService.deleteUserProjectCareer(projectCareerId);

		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}

	@GetMapping("/resume/{username}")
	@ApiOperation(value = "유저 이력사항 조회", notes = "로그인한 회원의 이력사항을 조회한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "성공"),
			@ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "사용자 없음"),
			@ApiResponse(code = 500, message = "서버 오류")
	})
	public ResponseEntity<UserResumeRes> getUserResumeList(@PathVariable String username) {
		//username(id)로 이력서에서 resume_id 찾기
		Long resume_id = userService.getResumeIdByUsername(username);

		//resume_id로 학력 받아오기
		UserEducationRes education = educationService.getEducationByResumeId(resume_id);

		//resume_id로 경력 받아오기
		List<UserCareerRes> careerList = careerService.getCareerAllListByResumeId(resume_id);

		//resume_id로 자격 받아오기
		List<UserCertificateRes> certificateList = certificateService.getCertificateAllListByResumeId(resume_id);

		//찾아온 정보를 UserResumeRes에 담아 값 전달하기
		return ResponseEntity.status(200).body(UserResumeRes.of(education, careerList, certificateList));
	}

	@PostMapping("/resume")
	@ApiOperation(value = "유저 이력 사항 등록", notes = "유저의 이력 사항을 등록한다. ")
	@ApiResponses({
			@ApiResponse(code = 200, message = "성공"),
			@ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "사용자 없음"),
			@ApiResponse(code = 500, message = "서버 오류")
	})
	public ResponseEntity<? extends BaseResponseBody> registerUserResume(
			@ApiIgnore Authentication authentication,
			@RequestBody @ApiParam(value="프로젝트 이력 정보", required = true) UserResumeRegisterPostReq registerResumeInfo) {
		SsafyUserDetails userDetails = (SsafyUserDetails)authentication.getDetails();
		String userId = userDetails.getUsername();
		User user = userService.getUserByUsername(userId).get();

		//먼저 userId를 resume 테이블에 등록
		Resume resume = userService.createResume(user);
		System.out.println("========== resumeId:"+resume.getResumeId());

		//등록된 resume_id로 education 테이블에 학력 정보 등록
		userService.createEducation(resume, registerResumeInfo.getEducation());
		System.out.println("Edu========== resumeId:"+resume.getResumeId()+"/ userId: "+resume.getUser().getUserId());

		//등록된 resume_id로 career 테이블에 경력 정보 등록
		userService.createCareer(resume, registerResumeInfo.getCareerList());

		//등록된 resume_id로 certificate 테이블에 자격 정보 등록
		userService.createCertificate(resume, registerResumeInfo.getCertificateList());

		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}

	@GetMapping()
	@ApiOperation(value = "프리랜서 전체 조회", notes = "프리랜서 전체 목록을 조회합니다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "성공"),
			@ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "사용자 없음"),
			@ApiResponse(code = 500, message = "서버 오류")
	})
	public List<User> getFreelancerList(Pageable pageable) {
		return userService.getFreelancers(pageable).getContent();
	}

//	@GetMapping("/filter")
//	@ApiOperation(value = "프리랜서 필터링 조회", notes = "프리랜서를 기술로 필터링해 리스트로 가져옵니다.")
//	@ApiResponses({
//			@ApiResponse(code = 200, message = "성공"),
//			@ApiResponse(code = 401, message = "인증 실패"),
//			@ApiResponse(code = 404, message = "사용자 없음"),
//			@ApiResponse(code = 500, message = "서버 오류")
//	})
//	public ResponseEntity<?> getProjectByFilter(@RequestParam List<String> techList ) {
//		return new ResponseEntity<List<User>>(userService.getFreelancersByTechs(techList), HttpStatus.OK);
//	}

	@PostMapping("/profile/tech/{username}")
	@ApiOperation(value = "프리랜서 프로필 기술 등록", notes = "프리랜서가 선택한 기술들을 프로필에 등록한다")
	@ApiResponses({
			@ApiResponse(code = 200, message = "성공"),
			@ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "사용자 없음"),
			@ApiResponse(code = 500, message = "서버 오류")
	})
	public ResponseEntity<?> registerProfileTech(
			@ApiParam(value="username", required = true) @PathVariable("username") String username, @RequestParam List<String> techList) {
		userService.createProfileTech(username,techList);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}

	@GetMapping("/profile/tech/{profileId}")
	@ApiOperation(value = "프리랜서 프로필 기술 조회", notes = "프리랜서가 선택한 기술들을 프로필에서 조회한다")
	@ApiResponses({
			@ApiResponse(code = 200, message = "성공"),
			@ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "사용자 없음"),
			@ApiResponse(code = 500, message = "서버 오류")
	})
	public ResponseEntity<?> getProfileTechList(
			@ApiParam(value="프로필 id", required = true) @PathVariable("profileId") Long profileId) {

		return new ResponseEntity<List<Tech>>(profileService.getTechsByProfileId(profileId), HttpStatus.OK);
	}

	@PostMapping("/profile")
	@ApiOperation(value = "프로필 등록", notes = "프로필을 등록한다")
	@ApiResponses({
			@ApiResponse(code = 200, message = "성공"),
			@ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "사용자 없음"),
			@ApiResponse(code = 500, message = "서버 오류")
	})
	public ResponseEntity<?> registerProfile(
			@RequestBody @ApiParam(value="프로필 정보", required = true) UserProfileFetchReq userProfileFetchReq, @ApiIgnore Authentication authentication) {

		SsafyUserDetails userDetails = (SsafyUserDetails)authentication.getDetails();
		User user = userDetails.getUser();
		userService.createProfile(userProfileFetchReq,user);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}

	@PostMapping("/project/tech/{projectCareerId}")
	@ApiOperation(value = "프리랜서 프로젝트 이력 기술 등록", notes = "프리랜서가 선택한 기술들을 프로젝트 이력에 등록한다")
	@ApiResponses({
			@ApiResponse(code = 200, message = "성공"),
			@ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "사용자 없음"),
			@ApiResponse(code = 500, message = "서버 오류")
	})
	public ResponseEntity<?> registerProjectCareerTech(
			@ApiParam(value="projectCareerId", required = true) @PathVariable("projectCareerId") Long projectCareerId, @RequestParam List<String> techList) {
		userService.createProjectCareerTech(projectCareerId,techList);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}

	@GetMapping("/project/tech/{projectCareerId}")
	@ApiOperation(value = "프리랜서 프로젝트 이력 기술 조회", notes = "프리랜서가 선택한 기술들을 프로젝트 이력에서 조회한다")
	@ApiResponses({
			@ApiResponse(code = 200, message = "성공"),
			@ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "사용자 없음"),
			@ApiResponse(code = 500, message = "서버 오류")
	})
	public ResponseEntity<?> getProjectCareerTechList(
			@ApiParam(value="프로젝트 이력 id", required = true) @PathVariable("projectCareerId") Long projectCareerId) {

		return new ResponseEntity<List<Tech>>(projectCareerService.getTechsByProjectCareerId(projectCareerId), HttpStatus.OK);
	}

	@GetMapping("/account")
	@ApiOperation(value = "프리랜서 회원 계좌 주소 조회", notes = "프리랜서 회원의 계좌 주소를 조회한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "성공"),
			@ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "사용자 없음"),
			@ApiResponse(code = 500, message = "서버 오류")
	})
	public ResponseEntity<?> getAccountAddress(@RequestParam String username) {
		String accountAddress = userService.getUserAccountAddressByUsername(username);
		return ResponseEntity.status(200).body(accountAddress);
	}

	@GetMapping("/account/{userId}")
	@ApiOperation(value = "프리랜서 회원 계좌 주소 조회", notes = "프리랜서 회원의 계좌 주소를 조회한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "성공"),
			@ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "사용자 없음"),
			@ApiResponse(code = 500, message = "서버 오류")
	})
	public ResponseEntity<?> getAccountAddressByUserId(@PathVariable("userId") Long userId) {
		String accountAddress = userService.getUserAccountAddressByUserId(userId);
		return ResponseEntity.status(200).body(accountAddress);
	}

	@GetMapping("/username/{userId}")
	@ApiOperation(value = "프리랜서 이름 조회", notes = "프리랜서 아이디로 프리랜서 이름 조회")
	@ApiResponses({
			@ApiResponse(code = 200, message = "성공"),
			@ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "사용자 없음"),
			@ApiResponse(code = 500, message = "서버 오류")
	})
	public ResponseEntity<?> getUsernameByUserId(
			@ApiParam(value="프리랜서 id", required = true) @PathVariable("userId") Long userId) {

		return new ResponseEntity<String>(userService.getUsernameByUserId(userId), HttpStatus.OK);
	}

	@GetMapping("/filter")
	@ApiOperation(value = "프리랜서 필터링 조회", notes = "프리랜서를 기술로 필터링해 리스트로 가져옵니다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "성공"),
			@ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "사용자 없음"),
			@ApiResponse(code = 500, message = "서버 오류")
	})
	public ResponseEntity<?> getProjectByFilter(@RequestParam List<String> techList, Pageable pageable ) {
		return new ResponseEntity<List<User>>(userService.getFreelancersByTechsPaging(techList,pageable).getContent(), HttpStatus.OK);
	}

	// 아이디 중복 확인
	@GetMapping("/username/{username}/exists")
	public ResponseEntity<Boolean> checkUsernameDuplicate(@PathVariable String username) {
		return ResponseEntity.ok(userService.checkUsernameDuplicate(username));

	}
}
