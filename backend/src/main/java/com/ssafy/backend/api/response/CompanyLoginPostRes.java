package com.ssafy.backend.api.response;

import com.ssafy.backend.common.model.response.BaseResponseBody;
import com.ssafy.backend.db.entity.Company;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("CompanyLoginPostResponse")
public class CompanyLoginPostRes extends BaseResponseBody {
    @ApiModelProperty(name="JWT 인증 토큰", example="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN...")
    String accessToken;

    Long companyId;
    String username;
    String email;
    String name;
    String phone;

    public static CompanyLoginPostRes of(Integer statusCode, String message, String accessToken, Company company) {
        CompanyLoginPostRes res = new CompanyLoginPostRes();
        res.setStatusCode(statusCode);
        res.setMessage(message);
        res.setAccessToken(accessToken);

        res.setCompanyId(company.getCompanyId());
        res.setUsername(company.getUsername());
        res.setEmail(company.getEmail());
        res.setName(company.getName());
        res.setPhone(company.getPhone());
        return res;
    }
}
