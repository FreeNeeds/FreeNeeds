package com.ssafy.backend.api.response;

import com.ssafy.backend.common.model.response.BaseResponseBody;
import com.ssafy.backend.db.entity.Apply;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@ApiModel("ApplyListResponse")
public class ApplyListRes extends BaseResponseBody {
    List<Apply> applyList;

    public static ApplyListRes of(Integer statusCode, String message, List<Apply> applyList) {
        ApplyListRes res = new ApplyListRes();
        res.setStatusCode(statusCode);
        res.setMessage(message);
        res.setApplyList(applyList);
        return res;
    }

}
