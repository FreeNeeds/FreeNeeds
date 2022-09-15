package com.ssafy.backend.api.controller;

import com.ssafy.backend.api.request.CompanyRegisterPostReq;
import com.ssafy.backend.api.service.CompanyService;
import com.ssafy.backend.common.model.response.BaseResponseBody;
import com.ssafy.backend.db.entity.Company;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        //임의로 리턴된 User 인스턴스. 현재 코드는 회원 가입 성공 여부만 판단하기 때문에 굳이 Insert 된 유저 정보를 응답하지 않음.
        Company company = companyService.createCompany(registerInfo);

        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }
}
