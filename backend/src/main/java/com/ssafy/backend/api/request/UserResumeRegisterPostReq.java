package com.ssafy.backend.api.request;

import com.ssafy.backend.db.entity.Career;
import com.ssafy.backend.db.entity.Certificate;
import com.ssafy.backend.db.entity.Education;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 이력서 등록 API ([POST] /api/v1/users/resume) 요청에 대한 응답값 정의.
 */
@Getter
@Setter
@ApiModel("UserResumeRegisterPostResponse")
public class UserResumeRegisterPostReq {
    //학력사항
    @ApiModelProperty(name = "학력사항")
    Education education;

    //경력사항
    @ApiModelProperty(name = "경력사항")
    List<Career> careerList;

    //자격사항
    @ApiModelProperty(name = "자격사항")
    List<Certificate> certificateList;
}
