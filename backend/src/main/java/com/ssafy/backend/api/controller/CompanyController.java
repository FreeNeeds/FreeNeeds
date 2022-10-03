package com.ssafy.backend.api.controller;

import com.ssafy.backend.api.request.CompanyInfoPostReq;
import com.ssafy.backend.api.request.CompanyRegisterPostReq;
import com.ssafy.backend.api.response.CompanyInfoRes;
import com.ssafy.backend.api.response.CompanyRes;
import com.ssafy.backend.api.service.CompanyService;
import com.ssafy.backend.common.auth.SsafyCompanyDetails;
import com.ssafy.backend.common.model.response.BaseResponseBody;
import com.ssafy.backend.common.util.RSAUtil;
import com.ssafy.backend.db.entity.Company;
import com.ssafy.backend.db.entity.CompanyInfo;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.Map;

@Api(value = "기업 API", tags = {"Company"})
@RestController
@RequestMapping("/api/v1/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping()
    @ApiOperation(value = "회원 가입", notes = "<strong>아이디와 패스워드</strong>를 통해 기업이 회원가입 한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<? extends BaseResponseBody> register(
            @RequestBody @ApiParam(value="회원가입 정보", required = true)@Validated CompanyRegisterPostReq registerInfo) {
        //RSA 공개키, 개인키 발급
        HashMap<String, String> rsaKeyPair = RSAUtil.createKeypairAsString();
        String publicKey = rsaKeyPair.get("publicKey");
        String privateKey = rsaKeyPair.get("privateKey");

        //임의로 리턴된 User 인스턴스. 현재 코드는 회원 가입 성공 여부만 판단하기 때문에 굳이 Insert 된 유저 정보를 응답하지 않음.
        companyService.createCompany(registerInfo, publicKey, privateKey);
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }

    @GetMapping("/me")
    @ApiOperation(value = "기업회원조회", notes = "토큰을 이용해 기업회원정보를 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<CompanyRes> getCompany(@ApiIgnore Authentication authentication) {
        SsafyCompanyDetails companyDetails = (SsafyCompanyDetails)authentication.getDetails();
        String username = companyDetails.getUsername();
        Company company = companyService.getCompanyByUsername(username).get();
        return ResponseEntity.status(200).body(CompanyRes.of(200,"Success", company));
    }

    @PatchMapping("/me")
    @ApiOperation(value = "회원정보수정", notes = "토큰을 이용해 기업회원정보를 수정한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = BaseResponseBody.class),
    })
    public ResponseEntity<? extends BaseResponseBody> updateCompany(@ApiIgnore Authentication authentication, @RequestBody Map<Object, Object> objectMap) {
        SsafyCompanyDetails companyDetails = (SsafyCompanyDetails)authentication.getDetails();
        String username = companyDetails.getUsername();
        companyService.updateCompany(username, objectMap);
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }


    @PostMapping("/information")
    @ApiOperation(value = "기업정보 생성", notes = "토큰을 이용해 기업정보를 생성한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = BaseResponseBody.class),
    })
    public ResponseEntity<? extends BaseResponseBody> createCompanyInfo(@ApiIgnore Authentication authentication, @RequestBody @ApiParam(value="기업정보생성", required = true) @Validated CompanyInfoPostReq companyInfoPostReq) {
        SsafyCompanyDetails companyDetails = (SsafyCompanyDetails)authentication.getDetails();
        String username = companyDetails.getUsername();
        Company company = companyService.getCompanyByUsername(username).get();
        companyService.createCompanyInfo(company, companyInfoPostReq);
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }

    @GetMapping("/information/{username}")
    @ApiOperation(value = "기업정보 조회", notes = "username으로 기업정보를 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = BaseResponseBody.class),
    })
    public ResponseEntity<? extends BaseResponseBody> getCompanyInfo(@PathVariable String username) {
        CompanyInfo companyInfo = companyService.getCompanyInfoByCompanyUsername(username).get();
        return ResponseEntity.status(200).body(CompanyInfoRes.of(200, "Success", companyInfo));
    }

    @PatchMapping("/information")
    @ApiOperation(value = "기업정보 수정", notes = "토큰을 이용해 기업정보를 수정한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = BaseResponseBody.class),
    })
    public ResponseEntity<? extends BaseResponseBody> updateCompanyInfo(@ApiIgnore Authentication authentication, @RequestBody Map<Object, Object> objectMap) {
        SsafyCompanyDetails companyDetails = (SsafyCompanyDetails)authentication.getDetails();
        String username = companyDetails.getUsername();
        companyService.updateCompanyInfo(username, objectMap);
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }

    @GetMapping("/account")
    @ApiOperation(value = "기업회원 계좌 주소 조회", notes = "기업회원의 계좌 주소를 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> getAccountAddress(@RequestParam String username) {
        String accountAddress = companyService.getCompanyAccountAddressByUsername(username);
        return ResponseEntity.status(200).body(accountAddress);
    }

    @GetMapping("/account/{companyId}")
    @ApiOperation(value = "기업 회원 계좌 주소 조회", notes = "기업 회원의 계좌 주소를 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> getAccountAddressByUserId(@PathVariable("companyId") Long companyId) {
        String accountAddress = companyService.getCompanyAccountAddressByCompanyId(companyId);
        return ResponseEntity.status(200).body(accountAddress);
    }
}
