package com.ssafy.backend.api.response;

import com.ssafy.backend.db.entity.ProjectCareer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 프로젝트 이력 조회 API ([GET] /api/v1/users/project/{username}) 요청에 대한 응답값 정의.
 */
@Getter
@Setter
@ApiModel("UserProjectCareerResponse")
public class UserProjectCareerRes {
    @ApiModelProperty(name="User ProjectCareer Serial ID")
    Long projectCareerId;

    @ApiModelProperty(name="User Serial ID")
    Long userId;

    @ApiModelProperty(name = "분야", example = "개발")
    String category;

    @ApiModelProperty(name = "형태", example = "앱")
    String domain;

    @ApiModelProperty(name = "기업명", example = "한국투자공사")
    String companyName;

    @ApiModelProperty(name = "프로젝트명", example = "모바일 가상화 시스템 구축")
    String title;

    @ApiModelProperty(name = "담당업무", example = "앱 개발")
    String content;

    @ApiModelProperty(name = "시작날짜", example = "2020-04-01")
    Date start_date;

    @ApiModelProperty(name = "종료날짜", example = "2020-10-31")
    Date end_date;

    public static UserProjectCareerRes of(ProjectCareer projectCareer) {
        UserProjectCareerRes res = new UserProjectCareerRes();

        res.setProjectCareerId(projectCareer.getProjectCareerId());
        res.setUserId(projectCareer.getUser().getUserId());

        res.setCategory(projectCareer.getCategory());
        res.setDomain(projectCareer.getDomain());
        res.setCompanyName(projectCareer.getCompanyName());
        res.setTitle(projectCareer.getTitle());
        res.setContent(projectCareer.getContent());
        res.setStart_date(projectCareer.getStart_date());
        res.setEnd_date(projectCareer.getEnd_date());

        return res;
    }
}
