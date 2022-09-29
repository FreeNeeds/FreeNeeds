package com.ssafy.backend.api.response;

import com.ssafy.backend.db.entity.Contract;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 계약서 조회 API ([GET] /api/v1/contracts/{userId}) 요청에 대한 응답값 정의.
 */
@Getter
@Setter
@ApiModel("ContractResponse")
public class ContractRes {
    @ApiModelProperty(name = "contractId")
    Long contractId;

    @ApiModelProperty(name = "userId")
    Long userId;

    @ApiModelProperty(name = "projectId")
    Long projectId;

    @ApiModelProperty(name = "이미지 경로")
    String imgSRC;

    @ApiModelProperty(name = "계약 내용")
    String content;

    public static ContractRes of(Contract contract) {
        ContractRes res = new ContractRes();

        res.setContractId(contract.getContractId());
        res.setUserId(contract.getUser().getUserId());
        res.setProjectId(contract.getProject().getProjectId());
        res.setImgSRC(contract.getImgSRC());
        res.setContent(contract.getContent());

        return res;
    }
}
