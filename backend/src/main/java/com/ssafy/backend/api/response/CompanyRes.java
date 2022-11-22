package com.ssafy.backend.api.response;

import com.ssafy.backend.common.model.response.BaseResponseBody;
import com.ssafy.backend.db.entity.Company;
import com.ssafy.backend.db.entity.CompanyInfo;
import com.ssafy.backend.db.entity.User;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("CompanyResponse")
public class CompanyRes extends BaseResponseBody {

    Company company;

    public static CompanyRes of(Integer statusCode, String message, Company company) {
        CompanyRes res = new CompanyRes();
        res.setStatusCode(statusCode);
        res.setMessage(message);
        res.setCompany(company);
        return res;
    }
}
