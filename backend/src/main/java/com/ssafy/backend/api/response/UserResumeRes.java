package com.ssafy.backend.api.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 이력사항 조회 API ([GET] /api/v1/users/resume/{username}) 요청에 대한 응답값 정의.
 */
@Getter
@Setter
@ApiModel("UserResumeResponse")
public class UserResumeRes {
    //학력사항
    @ApiModelProperty(name = "학력사항")
    UserEducationRes education;

    //경력사항
    @ApiModelProperty(name = "경력사항")
    List<UserCareerRes> careerList;

    //자격사항
    @ApiModelProperty(name = "자격사항")
    List<UserCertificateRes> certificateList;

    public static UserResumeRes of(
            UserEducationRes education,
            List<UserCareerRes> careerList,
            List<UserCertificateRes> certificateList) {
        UserResumeRes res = new UserResumeRes();

        //학력
        res.setEducation(education);
        //경력
        res.setCareerList(careerList);
        //자격
        res.setCertificateList(certificateList);

        return res;
    }
}
