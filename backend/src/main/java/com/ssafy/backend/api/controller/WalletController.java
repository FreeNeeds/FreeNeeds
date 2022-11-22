package com.ssafy.backend.api.controller;

import com.ssafy.backend.api.response.WalletRes;
import com.ssafy.backend.api.service.WalletService;
import com.ssafy.backend.common.model.response.BaseResponseBody;
import com.ssafy.backend.db.entity.Wallet;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 지갑 관련 API 요청 처리를 위한 컨트롤러 정의.
 */
@Api(value = "지갑 API", tags = {"Wallet"})
@RestController
@RequestMapping("/api/v1/wallets")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @PostMapping("/{username}")
    @ApiOperation(value = "유저 지갑 계정 주소 등록", notes = "유저의 메타마스크 지갑 주소를 등록한다. ")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<? extends BaseResponseBody> registerWallet(
            @PathVariable String username,
            @RequestBody @ApiParam(value="지갑 계정 주소", required = true) String accountAddress) {
        //userId와 accountAddress 등록
        Wallet wallet = walletService.createWallet(username, accountAddress);

        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }

    @GetMapping("/{username}")
    @ApiOperation(value = "유저 지갑 조회", notes = "로그인한 회원의 지갑 주소를 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<? extends BaseResponseBody> getWallet(@PathVariable String username) {
        //userId로 지갑 테이블에서 일치하는 정보 찾아오기
        Wallet wallet = walletService.getWalletByUsername(username);

        //찾아온 정보를 WalletRes에 담아 값 전달하기
        return ResponseEntity.status(200).body(WalletRes.of(200, "Success", wallet));
    }

    @PatchMapping("/{username}")
    @ApiOperation(value = "유저 계좌 주소 수정", notes = "유저 계좌 주소를 수정 후 응답한다")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "실패"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<? extends BaseResponseBody> updateWallet(
            @PathVariable String username,
            @RequestBody @ApiParam(value="지갑 계정 주소", required = true) String accountAddress) {
        walletService.updateWallet(username, accountAddress);

        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }
}
