package com.ssafy.backend.api.controller;

import com.ssafy.backend.api.request.ApplyReq;
import com.ssafy.backend.api.response.ApplyRes;
import com.ssafy.backend.api.service.ApplyService;
import com.ssafy.backend.api.service.ProjectService;
import com.ssafy.backend.api.service.UserService;
import com.ssafy.backend.common.model.response.BaseResponseBody;
import com.ssafy.backend.db.entity.Apply;
import com.ssafy.backend.db.entity.Project;
import com.ssafy.backend.db.entity.User;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Api(value = "지원 API", tags = {"Apply"})
@RestController
@RequestMapping("/api/v1/apply")
@RequiredArgsConstructor
public class ApplyController {

    private final ApplyService applyService;

    private final UserService userService;

    private final ProjectService projectService;

    @PostMapping
    @ApiOperation(value = "지원하기", notes = "프리랜서가 기업프로젝트에 지원함")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = BaseResponseBody.class),
    })
    public ResponseEntity<? extends BaseResponseBody> createApply(@RequestBody @ApiParam(value = "지원하기", required = true) ApplyReq applyReq) {
        Long userId = applyReq.getUserId();
        Long projectId = applyReq.getProjectId();
        String state = applyReq.getState();
        Optional<User> user = userService.getUserByUserId(userId);
        Project project = projectService.getProjectByProjectId(projectId);
        if (user.isPresent()) {
            Apply apply = applyService.createApply(state, user.get(), project);
            return ResponseEntity.status(200).body(ApplyRes.of(200, "success", apply));
        }
        throw new IllegalArgumentException("존재하지 않는 유저입니다.");
    }

    @PutMapping
    @ApiOperation(value = "지원상태변경", notes = "계약과정에 따라 지원상태변경")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = BaseResponseBody.class),
    })
    public ResponseEntity<? extends BaseResponseBody> updateApply(@RequestBody @ApiParam(value = "지원상태변경", required = true) ApplyReq applyReq) {
        Long userId = applyReq.getUserId();
        Long projectId = applyReq.getProjectId();
        String state = applyReq.getState();
        Optional<User> user = userService.getUserByUserId(userId);
        Project project = projectService.getProjectByProjectId(projectId);
        if (user.isPresent()) {
            Apply apply = applyService.updateApply(state, user.get(), project);
            return ResponseEntity.status(200).body(ApplyRes.of(200, "success", apply));
        }
        throw new IllegalArgumentException("존재하지 않는 유저입니다.");
    }

    @DeleteMapping
    @ApiOperation(value = "지원취소", notes = "지원취소")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = BaseResponseBody.class),
    })
    public ResponseEntity<? extends BaseResponseBody> deleteApply(@RequestBody @ApiParam(value = "지원취소", required = true) ApplyReq applyReq) {
        Long userId = applyReq.getUserId();
        Long projectId = applyReq.getProjectId();
        Optional<User> user = userService.getUserByUserId(userId);
        Project project = projectService.getProjectByProjectId(projectId);
        if (user.isPresent()) {
            BaseResponseBody baseResponseBody = applyService.deleteApply(user.get(), project);
            Integer statusCode = baseResponseBody.getStatusCode();
            return ResponseEntity.status(statusCode).body(baseResponseBody);
        }
        throw new IllegalArgumentException("존재하지 않는 유저입니다.");
    }
}