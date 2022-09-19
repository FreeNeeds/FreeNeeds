package com.ssafy.backend.api.response;

import com.ssafy.backend.db.entity.Career;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@ApiModel("UserCareerResponse")
public class UserCareerRes {
    @ApiModelProperty(name = "회사명", example = "(주)엠로")
    String companyName;

    @ApiModelProperty(name = "부서명", example = "웹개발부")
    String department;

    @ApiModelProperty(name = "직책명", example = "수석연구원")
    String position;

    @ApiModelProperty(name = "시작날짜", example = "2015-03-01")
    Date start_date;

    @ApiModelProperty(name = "종료날짜", example = "2020-02-01")
    Date end_date;

    public static UserCareerRes of(Career career) {
        UserCareerRes res = new UserCareerRes();

        res.setCompanyName(career.getCompanyName());
        res.setDepartment(career.getDepartment());
        res.setPosition(career.getPosition());
        res.setStart_date(career.getStart_date());
        res.setEnd_date(career.getEnd_date());

        return res;
    }
}
