package com.ssafy.backend.api.response;

import com.ssafy.backend.common.model.response.BaseResponseBody;
import com.ssafy.backend.db.entity.Wallet;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 지갑 조회 API ([GET] /api/v1/wallets/{username}) 요청에 대한 응답값 정의.
 */
@Getter
@Setter
@ApiModel("WalletResponse")
public class WalletRes extends BaseResponseBody {
    //지갑 serial
    @ApiModelProperty(name = "지갑 serial")
    Long walletId;

    //userId
    @ApiModelProperty(name = "유저 ID")
    String username;

    //metamask account address
    @ApiModelProperty(name = "지갑 계정 주소")
    String accountAddress;

    public static WalletRes of(Integer statusCode, String message, Wallet wallet) {
        WalletRes res = new WalletRes();

        res.setStatusCode(statusCode);
        res.setMessage(message);
        res.setWalletId(wallet.getWalletId());
        res.setUsername(wallet.getUsername());
        res.setAccountAddress(wallet.getAccountAddress());

        return res;
    }
}
