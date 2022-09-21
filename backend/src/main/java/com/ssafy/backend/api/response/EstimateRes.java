package com.ssafy.backend.api.response;

import com.ssafy.backend.db.entity.Estimate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 평점 조회 API ([GET] /api/v1/estimates/{username}) 요청에 대한 응답값 정의.
 */
@Getter
@Setter
@ApiModel("EstimateResponse")
public class EstimateRes {
    @ApiModelProperty(name = "전문성", example = "3.0")
    Float profession;

    @ApiModelProperty(name = "일정준수", example = "4.0")
    Float ontime;

    @ApiModelProperty(name = "적극성", example = "5.0")
    Float active;

    @ApiModelProperty(name = "의사소통", example = "5.0")
    Float communication;

    @ApiModelProperty(name = "재고용 의사", example = "4.0")
    Float reEmployment;


    public static EstimateRes of(Estimate estimate) {
        EstimateRes res = new EstimateRes();

        res.setProfession(estimate.getProfession());
        res.setOntime(estimate.getOntime());
        res.setActive(estimate.getActive());
        res.setCommunication(estimate.getCommunication());
        res.setReEmployment(estimate.getReEmployment());

        return res;
    }
}
