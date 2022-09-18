package com.ssafy.backend.api.response;

import com.ssafy.backend.common.model.response.BaseResponseBody;
import com.ssafy.backend.db.entity.Apply;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("ApplyPostPutResponse")
public class ApplyPostPutRes extends BaseResponseBody {
    Apply apply;

    public static ApplyPostPutRes of(Integer statusCode, String message, Apply apply) {
        ApplyPostPutRes res = new ApplyPostPutRes();
        res.setMessage(message);
        res.setStatusCode(statusCode);
        res.setApply(apply);
        return res;
    }
}
