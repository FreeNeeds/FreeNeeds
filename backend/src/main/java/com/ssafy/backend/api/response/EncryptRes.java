package com.ssafy.backend.api.response;

import com.ssafy.backend.common.model.response.BaseResponseBody;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("EncryptResponse")
public class EncryptRes extends BaseResponseBody {

    @ApiModelProperty(name = "encryptData")
    String encryptData;

    @ApiModelProperty(name = "publicKey")
    String publicKey;

    public static EncryptRes of(Integer statusCode, String message, String encryptData, String publicKey) {
        EncryptRes res = new EncryptRes();
        res.setStatusCode(statusCode);
        res.setMessage(message);
        res.setEncryptData(encryptData);
        res.setPublicKey(publicKey);
        return res;
    }
}
