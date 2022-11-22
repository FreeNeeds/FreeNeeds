package com.ssafy.backend.api.controller;

import com.ssafy.backend.api.request.ContractRegisterPostReq;
import com.ssafy.backend.api.response.ContractRes;
import com.ssafy.backend.api.response.EncryptRes;
import com.ssafy.backend.api.service.CompanyService;
import com.ssafy.backend.api.service.ContractService;
import com.ssafy.backend.api.service.ProjectService;
import com.ssafy.backend.api.service.UserService;
import com.ssafy.backend.common.auth.SsafyCompanyDetails;
import com.ssafy.backend.common.auth.SsafyUserDetails;
import com.ssafy.backend.common.model.response.BaseResponseBody;
import com.ssafy.backend.common.util.RSAUtil;
import com.ssafy.backend.db.entity.*;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 계약 관련 API 요청 처리를 위한 컨트롤러 정의.
 */
@Api(value = "계약 API", tags = {"Contract"})
@RestController
@RequestMapping("/api/v1/contracts")
@RequiredArgsConstructor
public class ContractController {

    private final ProjectService projectService;
    private final UserService userService;
    private final ContractService contractService;
    private final CompanyService companyService;

    @PostMapping()
    @ApiOperation(value = "프로젝트에 대한 계약서 등록", notes = "프로젝트에 대한 특정 유저와의 계약서를 등록한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<? extends BaseResponseBody> registerContract(
            @RequestParam Long projectId, @RequestParam Long userId,
            @RequestBody @ApiParam(value="계약서 정보", required = true) ContractRegisterPostReq registerContractInfo) {
        //projectId로 project 정보 가져오기
        Project project = projectService.getProjectByProjectId(projectId);
        //userId로 user 정보 가져오기
        User user = userService.getUserByUserId(userId).get();

        contractService.createContract(project, user, registerContractInfo);

        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }

    @GetMapping("")
    @ApiOperation(value = "유저가 계약한 프로젝트에 대한 계약서 조회", notes = "로그인한 회원이 계약한 프로젝트의 계약서를 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<ContractRes> getContract(@RequestParam Long userId, @RequestParam Long projectId) {
        //userId와 projectId로 계약서 테이블에서 일치하는 정보 찾아오기
        Contract contract = contractService.getContractByUserIdAndProjectId(userId, projectId);

        //찾아온 정보를 ContractRes에 담아 값 전달하기
        return ResponseEntity.status(200).body(ContractRes.of(contract));
    }

    @PatchMapping("/{userId}/{projectId}")
    @ApiOperation(value = "유저가 계약한 프로젝트에 대한 계약서 수정", notes = "로그인한 회원이 계약한 프로젝트의 계약서를 수정한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<? extends BaseResponseBody> updateContract( @PathVariable Long userId,  @PathVariable Long projectId,
                                                                      @RequestBody @ApiParam(value="수정할 계약 content", required = true) String content) {

        contractService.updateContract(userId,projectId,content);

        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }
    @GetMapping("/companySign")
    @ApiOperation(value = "기업 개인키 암호화", notes = "로그인한 기업이 계약서에 개인키로 암호화한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> getHashEncodeCompany(
            @RequestParam Long companyId, @RequestParam String plainData) {
        Company company = companyService.getCompanyByCompanyId(companyId);

        //로그인 된 기업 회원의 개인키 가져오기
        String privateKey = company.getPrivateKey();

        // 기업 회원의 공개키 가져오기
        String publicKey = company.getPublicKey();

        //개인키로 암호화하기
        String encryptedText = RSAUtil.encode(plainData, privateKey);

        //개인키로 암호화 된 값 전달하기
        return ResponseEntity.status(200).body(EncryptRes.of(200, "success", encryptedText, publicKey));
    }

    @GetMapping("/userSign")
    @ApiOperation(value = "프리랜서 개인키 암호화", notes = "로그인한 프리랜서가 계약서에 개인키로 암호화한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> getHashEncodeUser(
            @RequestParam Long userId, @RequestParam String plainData) {
        User user = userService.getUserByUserId(userId).get();

        //로그인 된 프리랜서 회원의 개인키 가져오기
        String privateKey = user.getPrivateKey();

        String publicKey = user.getPublicKey();

        //개인키로 암호화하기
        String encryptedText = RSAUtil.encode(plainData, privateKey);

        //개인키로 암호화 된 값 전달하기
        return ResponseEntity.status(200).body(EncryptRes.of(200, "success", encryptedText, publicKey));
    }

    @GetMapping("/companyCheck")
    @ApiOperation(value = "기업 공개키 복호화", notes = "로그인한 기업의 공개키로 복호화하여 원본과 일치한지 확인한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> getCompanyCheck(
            @RequestParam Long companyId, @RequestParam String encryptedData) {
        Company company = companyService.getCompanyByCompanyId(companyId);

        //로그인 된 기업 회원의 공개키 가져오기
        String publicKey = company.getPublicKey();

        //공개키로 암호화하기
        String decryptedText = RSAUtil.decode(encryptedData, publicKey);

        //공개키로 복호화 된 값 전달하기
        return ResponseEntity.status(200).body(decryptedText);
    }

    @GetMapping("/userCheck")
    @ApiOperation(value = "프리랜서 공개키 복호화", notes = "로그인한 프리랜서의 공개키로 복호화하여 원본과 일치한지 확인한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> getUserCheck(
            @RequestParam Long userId, @RequestParam String encryptedData) {
        User user = userService.getUserByUserId(userId).get();

        //로그인 된 프리랜서 회원의 공개키 가져오기
        String publicKey = user.getPublicKey();

        //공개키로 복호화하기
        String decryptedText = RSAUtil.decode(encryptedData, publicKey);

        //공개키로 복호화 된 값 전달하기
        return ResponseEntity.status(200).body(decryptedText);
    }
}
