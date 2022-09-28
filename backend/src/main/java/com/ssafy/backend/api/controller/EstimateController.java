package com.ssafy.backend.api.controller;

import com.ssafy.backend.api.request.EstimateRegisterPostReq;
import com.ssafy.backend.api.response.EstimateRes;
import com.ssafy.backend.api.service.EstimateService;
import com.ssafy.backend.api.service.UserService;
import com.ssafy.backend.common.model.response.BaseResponseBody;
import com.ssafy.backend.db.entity.User;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 평점 관련 API 요청 처리를 위한 컨트롤러 정의.
 */
@Api(value = "평점 API", tags = {"Estimate"})
@RestController
@RequestMapping("/api/v1/estimates")
@RequiredArgsConstructor
public class EstimateController {
    private final UserService userService;
    private final EstimateService estimateService;

    @PostMapping("/{username}")
    @ApiOperation(value = "유저에 대한 평점 등록", notes = "기업이 특정 유저에 대해 평점을 등록한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<? extends BaseResponseBody> registerEstimate(
            @PathVariable String username,
            @RequestBody @ApiParam(value="평점 정보", required = true) EstimateRegisterPostReq registerEstimateInfo) {

        //username(id)로 user 정보 가져오기
        User user = userService.getUserByUsername(username).get();

        estimateService.createEstimate(user, registerEstimateInfo);

        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }

    @GetMapping("/{username}")
    @ApiOperation(value = "유저에 대한 평점 조회", notes = "유저에 대한 평점 리스트를 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<List<EstimateRes>> getEstimateList(@PathVariable String username) {
        //user 정보로 해당되는 평점 리스트 가져오기
        List<EstimateRes> res = estimateService.getEstimateAllList(username);

        return ResponseEntity.status(200).body(res);
    }
}
