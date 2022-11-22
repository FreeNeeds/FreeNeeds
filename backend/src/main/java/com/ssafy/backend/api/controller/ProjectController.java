package com.ssafy.backend.api.controller;

import com.ssafy.backend.api.request.ProjectRegisterPostReq;
import com.ssafy.backend.api.service.ProjectService;
import com.ssafy.backend.common.auth.SsafyCompanyDetails;
import com.ssafy.backend.common.model.response.BaseResponseBody;
import com.ssafy.backend.db.entity.Company;
import com.ssafy.backend.db.entity.Project;
import com.ssafy.backend.db.entity.Tech;
import com.ssafy.backend.db.repository.ProjectTechRepositorySupport;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;


@Api(value = "프로젝트 API", tags = {"Project"})
@RestController
@RequestMapping("/api/v1/project")
@RequiredArgsConstructor
public class ProjectController {

    @Autowired
    ProjectService projectService;

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
//        Project project = projectService.createProject(registerInfo,company);
        return new ResponseEntity<Project>(projectService.createProject(registerInfo,company), HttpStatus.OK);
    }

//    @GetMapping()
//    @ApiOperation(value = "프로젝트 전체 조회", notes = "프로젝트 전체 목록을 조회합니다.")
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "성공"),
//            @ApiResponse(code = 401, message = "인증 실패"),
//            @ApiResponse(code = 404, message = "사용자 없음"),
//            @ApiResponse(code = 500, message = "서버 오류")
//    })
//    public ResponseEntity<?> getProjectList(Pageable pageable) {
//        return new ResponseEntity<List<Project>>(projectService.getProjects(), HttpStatus.OK);
//    }

    @GetMapping("/{projectId}")
    @ApiOperation(value = "프로젝트 상세 정보 조회", notes = "프로젝트 id값으로 상세 정보를 조회합니다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> getProjectInfo(@PathVariable("projectId") Long projectId ) {
        return new ResponseEntity<Project>(projectService.getProjectByProjectId(projectId), HttpStatus.OK);
    }

    @GetMapping("/tech/{projectId}")
    @ApiOperation(value = "프로젝트 관련 기술 조회", notes = "프로젝트 관련 기술들을 조회한다")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> registerProjectTech(
            @ApiParam(value="프로젝트 id", required = true) @PathVariable("projectId") Long projectId) {

        return new ResponseEntity<List<Tech>>(projectService.getTechsByProjectId(projectId), HttpStatus.OK);
    }

    @PostMapping("/tech/{projectId}")
    @ApiOperation(value = "프로젝트 관련 기술 등록", notes = "프로젝트 관련 기술들을 등록한다")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> registerProjectTech(
            @ApiParam(value="프로젝트 id", required = true) @PathVariable("projectId") Long projectId, @RequestParam List<String> techList) {
        projectService.createProjectTech(projectId,techList);
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }

    @GetMapping("/filter")
    @ApiOperation(value = "프로젝트 필터링 조회", notes = "프로젝트를 기술로 필터링해 리스트로 가져옵니다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> getProjectByFilter(@RequestParam List<String> techList, @RequestParam String locationSi, @RequestParam String locationGu, @RequestParam String category, @RequestParam List<String> domain ) {
        return new ResponseEntity<List<Project>>(projectService.getProjectsByTechs(techList,locationSi,locationGu,category,domain), HttpStatus.OK);
    }

    @GetMapping()
    @ApiOperation(value = "프로젝트 전체 조회", notes = "프로젝트 전체 목록을 조회합니다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public List<Project> getProjectList(Pageable pageable) {
        return projectService.getProjects(pageable).getContent();
    }


    @GetMapping("/company/{companyId}")
    @ApiOperation(value = "프로젝트 기업 조회", notes = "프로젝트를 기업ID를 통해 List로 받아옵니다")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> getProjectByCompanyId(@PathVariable("companyId") Long companyId) {
        return new ResponseEntity<List<Project>>(projectService.getProjectsByCompanyId(companyId), HttpStatus.OK);
    }

}
