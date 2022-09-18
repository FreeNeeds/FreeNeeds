package com.ssafy.backend.api.controller;

import com.ssafy.backend.api.request.ApplyPostReq;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<? extends BaseResponseBody> createApply(@RequestBody @ApiParam(value = "지원하기", required = true) ApplyPostReq applyPostReq) {
        Long userId = applyPostReq.getUserId();
        Long projectId = applyPostReq.getProjectId();
        String state = applyPostReq.getState();
        Optional<User> user = userService.getUserByUserId(userId);
        Project project = projectService.getProjectByProjectId(projectId);
        if (user.isPresent()) {
            Apply apply = applyService.createApply(state, user.get(), project);
            return ResponseEntity.status(200).body(ApplyRes.of(200, "success", apply));
        }
        throw new IllegalArgumentException("존재하지 않는 유저입니다.");
    }
}
