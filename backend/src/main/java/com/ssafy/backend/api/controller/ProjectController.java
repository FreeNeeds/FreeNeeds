package com.ssafy.backend.api.controller;

import com.ssafy.backend.api.request.ProjectRegisterPostReq;
import com.ssafy.backend.api.service.ProjectServie;
import com.ssafy.backend.common.auth.SsafyCompanyDetails;
import com.ssafy.backend.common.model.response.BaseResponseBody;
import com.ssafy.backend.db.entity.Company;
import com.ssafy.backend.db.entity.Project;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;


@Api(value = "프로젝트 API", tags = {"Project"})
@RestController
@RequestMapping("/api/v1/project")
@RequiredArgsConstructor
public class ProjectController {

    @Autowired
    ProjectServie projectServie;

    @PostMapping()
    @ApiOperation(value = "프로젝트 등록", notes = "프로젝트를 등록한다")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> registerProject(
            @RequestBody @ApiParam(value="프로젝트 정보", required = true) ProjectRegisterPostReq registerInfo, @ApiIgnore Authentication authentication) {
        SsafyCompanyDetails companyDetails = (SsafyCompanyDetails)authentication.getDetails();
        Company company = companyDetails.getCompany();
        Project project = projectServie.createProject(registerInfo,company);
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }

    @GetMapping("/{projectId}")
    @ApiOperation(value = "프로젝트 상세 정보 조회", notes = "프로젝트 id값으로 상세 정보를 조회합니다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> getProjectInfo(@PathVariable("projectId") Long projectId ) {
        return new ResponseEntity<Project>(projectServie.getProjectByProjectId(projectId), HttpStatus.OK);
    }
}
