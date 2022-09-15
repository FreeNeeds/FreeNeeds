package com.ssafy.backend.api.controller;


import com.ssafy.backend.api.request.CompanyLoginPostReq;
import com.ssafy.backend.api.request.UserLoginPostReq;
import com.ssafy.backend.api.response.CompanyLoginPostRes;
import com.ssafy.backend.api.response.UserLoginPostRes;
import com.ssafy.backend.api.service.CompanyService;
import com.ssafy.backend.api.service.UserService;
import com.ssafy.backend.common.model.response.BaseResponseBody;
import com.ssafy.backend.common.util.JwtTokenUtil;
import com.ssafy.backend.db.entity.Company;
import com.ssafy.backend.db.entity.User;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

/**
 * 인증 관련 API 요청 처리를 위한 컨트롤러 정의.
 */
@Api(value = "인증 API", tags = {"Auth."})
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

	private final UserService userService;

	private final CompanyService companyService;
	private final PasswordEncoder passwordEncoder;
	
	@PostMapping("/user/login")
	@ApiOperation(value = "유저 로그인", notes = "<strong>아이디와 패스워드</strong>를 통해 유저가 로그인 한다.")
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공", response = UserLoginPostRes.class),
        @ApiResponse(code = 401, message = "인증 실패", response = BaseResponseBody.class),
        @ApiResponse(code = 404, message = "사용자 없음", response = BaseResponseBody.class),
        @ApiResponse(code = 500, message = "서버 오류", response = BaseResponseBody.class)
    })
	public ResponseEntity<UserLoginPostRes> login(@RequestBody @ApiParam(value="로그인 정보", required = true) @Validated UserLoginPostReq loginInfo) {
		String userId = loginInfo.getUsername();
		String password = loginInfo.getPassword();

		User user = userService.getUserByUsername(userId).orElseThrow(() -> new NoSuchElementException("The username that you have entered is invalid."));
		// 로그인 요청한 유저로부터 입력된 패스워드 와 디비에 저장된 유저의 암호화된 패스워드가 같은지 확인.(유효한 패스워드인지 여부 확인)
		if(passwordEncoder.matches(password, user.getPassword())) {
			// 유효한 패스워드가 맞는 경우, 로그인 성공으로 응답.(액세스 토큰을 포함하여 응답값 전달)
			return ResponseEntity.ok(UserLoginPostRes.of(200, "Success", JwtTokenUtil.getToken(userId),user));
		}
		// 유효하지 않는 패스워드인 경우, 로그인 실패로 응답.
		throw new BadCredentialsException("The password you entered is incorrect.");
	}

	@PostMapping("/company/login")
	@ApiOperation(value = "기업 로그인", notes = "<strong>아이디와 패스워드</strong>를 통해 기업이 로그인 한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "성공", response = UserLoginPostRes.class),
			@ApiResponse(code = 401, message = "인증 실패", response = BaseResponseBody.class),
			@ApiResponse(code = 404, message = "사용자 없음", response = BaseResponseBody.class),
			@ApiResponse(code = 500, message = "서버 오류", response = BaseResponseBody.class)
	})
	public ResponseEntity<CompanyLoginPostRes> login(@RequestBody @ApiParam(value="로그인 정보", required = true) @Validated CompanyLoginPostReq loginInfo) {
		String userId = loginInfo.getUsername();
		String password = loginInfo.getPassword();

		Company company = companyService.getCompanyByUsername(userId).orElseThrow(() -> new NoSuchElementException("The username that you have entered is invalid."));
		// 로그인 요청한 유저로부터 입력된 패스워드와 디비에 저장된 유저의 암호화된 패스워드가 같은지 확인.(유효한 패스워드인지 여부 확인)
		if(passwordEncoder.matches(password, company.getPassword())) {
			// 유효한 패스워드가 맞는 경우, 로그인 성공으로 응답.(액세스 토큰을 포함하여 응답값 전달)
			return ResponseEntity.ok(CompanyLoginPostRes.of(200, "Success", JwtTokenUtil.getToken(userId),company));
		}
		// 유효하지 않는 패스워드인 경우, 로그인 실패로 응답.
		throw new BadCredentialsException("The password you entered is incorrect.");
	}
}
