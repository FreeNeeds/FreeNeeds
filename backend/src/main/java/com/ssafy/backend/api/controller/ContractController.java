package com.ssafy.backend.api.controller;

import com.ssafy.backend.api.request.ContractRegisterPostReq;
import com.ssafy.backend.api.response.ContractRes;
import com.ssafy.backend.api.response.UserProfileRes;
import com.ssafy.backend.api.service.ContractService;
import com.ssafy.backend.api.service.ProjectService;
import com.ssafy.backend.api.service.UserService;
import com.ssafy.backend.common.model.response.BaseResponseBody;
import com.ssafy.backend.db.entity.Contract;
import com.ssafy.backend.db.entity.Profile;
import com.ssafy.backend.db.entity.Project;
import com.ssafy.backend.db.entity.User;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
