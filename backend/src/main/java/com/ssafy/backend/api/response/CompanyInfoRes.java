package com.ssafy.backend.api.response;

import com.ssafy.backend.common.model.response.BaseResponseBody;
import com.ssafy.backend.db.entity.CompanyInfo;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("CompanyInfoResponse")
public class CompanyInfoRes extends BaseResponseBody {
    CompanyInfo companyInfo;

    public static CompanyInfoRes of(Integer statusCode, String message, CompanyInfo companyInfo) {
        CompanyInfoRes res = new CompanyInfoRes();
        res.setStatusCode(statusCode);
        res.setMessage(message);
        res.setCompanyInfo(companyInfo);
        return res;
    }
}
