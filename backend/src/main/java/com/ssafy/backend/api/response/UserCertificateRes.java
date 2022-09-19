package com.ssafy.backend.api.response;

import com.ssafy.backend.db.entity.Certificate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@ApiModel("UserCertificateResponse")
public class UserCertificateRes {
    @ApiModelProperty(name = "취득일자", example = "2014-11-01")
    Date date;

    @ApiModelProperty(name = "자격증명", example = "정보처리기사")
    String name;

    @ApiModelProperty(name = "인증기관", example = "한국산업인력공단")
    String certification;

    public static UserCertificateRes of(Certificate certificate) {
        UserCertificateRes res = new UserCertificateRes();

        res.setDate(certificate.getDate());
        res.setName(certificate.getName());
        res.setCertification(certificate.getCertification());

        return res;
    }
}
