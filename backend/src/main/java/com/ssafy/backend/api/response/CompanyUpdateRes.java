package com.ssafy.backend.api.response;


import com.ssafy.backend.common.model.response.BaseResponseBody;
import com.ssafy.backend.db.entity.Company;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("CompanyUpdateResponse")
public class CompanyUpdateRes extends BaseResponseBody {

    Company company;

    public static CompanyUpdateRes of(Integer statusCode, String message, Company company) {
        CompanyUpdateRes res = new CompanyUpdateRes();
        res.setStatusCode(statusCode);
        res.setMessage(message);
        res.setCompany(company);
        return res;
    }

}
