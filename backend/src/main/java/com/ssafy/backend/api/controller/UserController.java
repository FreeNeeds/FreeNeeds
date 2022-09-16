package com.ssafy.backend.api.controller;

import com.ssafy.backend.api.request.UserProfileFetchReq;
import com.ssafy.backend.api.request.UserProjectRegisterPostReq;
import com.ssafy.backend.api.request.UserRegisterPostReq;
import com.ssafy.backend.api.response.UserProfileRes;
import com.ssafy.backend.api.response.UserProjectCareerRes;
import com.ssafy.backend.api.service.UserService;
import com.ssafy.backend.common.auth.SsafyUserDetails;
import com.ssafy.backend.common.model.response.BaseResponseBody;
import com.ssafy.backend.db.entity.Profile;
import com.ssafy.backend.db.entity.ProjectCareer;
import com.ssafy.backend.db.entity.User;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 유저 관련 API 요청 처리를 위한 컨트롤러 정의.
 */
@Api(value = "유저 API", tags = {"User"})
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	@PostMapping()
	@ApiOperation(value = "회원 가입", notes = "<strong>아이디와 패스워드</strong>를 통해 회원가입 한다.") 
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "인증 실패"),
        @ApiResponse(code = 404, message = "사용자 없음"),
        @ApiResponse(code = 500, message = "서버 오류")
    })
	public ResponseEntity<? extends BaseResponseBody> register(
			@RequestBody @ApiParam(value="회원가입 정보", required = true)@Validated UserRegisterPostReq registerInfo) {
		
		//임의로 리턴된 User 인스턴스. 현재 코드는 회원 가입 성공 여부만 판단하기 때문에 굳이 Insert 된 유저 정보를 응답하지 않음.
		User user = userService.createUser(registerInfo);
		
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
	@GetMapping("/profile")
	@ApiOperation(value = "유저 프로필 정보 조회", notes = "로그인한 회원의 프로필 정보를 조회한다.")
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "인증 실패"),
        @ApiResponse(code = 404, message = "사용자 없음"),
        @ApiResponse(code = 500, message = "서버 오류")
    })
	public ResponseEntity<UserProfileRes> getUserProfile(@ApiIgnore Authentication authentication) {
		/**
		 * 요청 헤더 액세스 토큰이 포함된 경우에만 실행되는 인증 처리이후, 리턴되는 인증 정보 객체(authentication) 통해서 요청한 유저 식별.
		 * 액세스 토큰이 없이 요청하는 경우, 403 에러({"error": "Forbidden", "message": "Access Denied"}) 발생.
		 */
		SsafyUserDetails userDetails = (SsafyUserDetails)authentication.getDetails();
		String userId = userDetails.getUsername();
		User user = userService.getUserByUsername(userId).get();

		//userId로 프로필 테이블에서 일치하는 정보 찾아오기
		Profile profile = userService.getProfileByUserId(user.getUserId());
		
		//찾아온 정보를 UserProfileRes에 담아 값 전달하기
		return ResponseEntity.status(200).body(UserProfileRes.of(user, profile));
	}

	@PatchMapping("/profile/{username}")
	@ApiOperation(value = "유저 프로필 수정", notes = "유저 프로필을 수정 후 응답한다")
	@ApiResponses({
			@ApiResponse(code = 200, message = "성공"),
			@ApiResponse(code = 401, message = "실패"),
			@ApiResponse(code = 500, message = "서버 오류")
	})
	public ResponseEntity<? extends BaseResponseBody> updateUserProfile(
			@PathVariable String username,
			@RequestBody @ApiParam(value = "유저 프로필 정보", required = true) UserProfileFetchReq userProfile) {
		userService.updateUserProfile(username, userProfile);

		System.out.println(userProfile.getIntroduce());

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
	public ResponseEntity<? extends BaseResponseBody> registerUserProject(
			@ApiIgnore Authentication authentication,
			@RequestBody @ApiParam(value="프로젝트 이력 정보", required = true) UserProjectRegisterPostReq registerProjectInfo) {
		SsafyUserDetails userDetails = (SsafyUserDetails)authentication.getDetails();
		String userId = userDetails.getUsername();
		User user = userService.getUserByUsername(userId).get();
		
		//userId와 입력된 프로젝트 이력 정보 등록
		ProjectCareer projectCareer = userService.createProjectCareer(user, registerProjectInfo);

		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
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
		//username(id)로 user 정보 가져오기
		User user = userService.getUserByUsername(username).get();

		//user 정보로 해당되는 프로젝트 이력 리스트 가져오기
		List<UserProjectCareerRes> res = userService.getProjectCareerAllList(user);

		//찾아온 정보를 UserProfileRes에 담아 값 전달하기
		return ResponseEntity.status(200).body(res);
	}
}
