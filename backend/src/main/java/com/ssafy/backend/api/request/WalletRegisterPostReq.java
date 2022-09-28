package com.ssafy.backend.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 지갑 등록 API ([POST] /api/v1/wallets) 요청에 대한 응답값 정의.
 */
@Getter
@Setter
@ApiModel("WalletRegisterPostRequest")
public class WalletRegisterPostReq {
    //userId
    @ApiModelProperty(name = "유저 ID")
    String username;

    //metamask account address
    @ApiModelProperty(name = "지갑 계정 주소")
    String accountAddress;
}
