package com.ssafy.backend.api.response;

import com.ssafy.backend.common.model.response.BaseResponseBody;
import com.ssafy.backend.db.entity.Apply;
import com.ssafy.backend.db.entity.CompanyInfo;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("ApplyResponse")
public class ApplyRes extends BaseResponseBody {
    Apply apply;

    public static ApplyRes of(Integer statusCode, String message, Apply apply) {
        ApplyRes res = new ApplyRes();
        res.setMessage(message);
        res.setStatusCode(statusCode);
        res.setApply(apply);
        return res;
    }
}
