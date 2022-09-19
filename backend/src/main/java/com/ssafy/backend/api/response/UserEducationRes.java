package com.ssafy.backend.api.response;

import com.ssafy.backend.db.entity.Education;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@ApiModel("UserEducationResponse")
public class UserEducationRes {
    @ApiModelProperty(name = "고등학교명", example = "싸피고등학교")
    String highschool;

    @ApiModelProperty(name = "고등학교 입학날짜", example = "2007-03-01")
    Date highschool_start_date;

    @ApiModelProperty(name = "고등학교 졸업날짜", example = "2010-02-01")
    Date highschool_end_date;

    @ApiModelProperty(name = "대학교명", example = "싸피대학교")
    String university;

    @ApiModelProperty(name = "대학교 입학날짜", example = "2010-03-01")
    Date university_start_date;

    @ApiModelProperty(name = "대학교 졸업날짜", example = "2015-02-01")
    Date university_end_date;

    @ApiModelProperty(name = "전공", example = "컴퓨터공학과")
    String major;

    public static UserEducationRes of(Education education) {
        UserEducationRes res = new UserEducationRes();

        res.setHighschool(education.getHighschool());
        res.setHighschool_start_date(education.getHighschool_start_date());
        res.setHighschool_end_date(education.getHighschool_end_date());
        res.setUniversity(education.getUniversity());
        res.setUniversity_start_date(education.getUniversity_start_date());
        res.setUniversity_end_date(education.getUniversity_end_date());
        res.setMajor(education.getMajor());

        return res;
    }
}
