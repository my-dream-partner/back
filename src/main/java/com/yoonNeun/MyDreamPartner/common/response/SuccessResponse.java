package com.yoonNeun.MyDreamPartner.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import static com.yoonNeun.MyDreamPartner.common.response.ResponseEnum.SUCCESS;

@Getter
public class SuccessResponse<T> extends BaseResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;

    public SuccessResponse(T result) {
        super(SUCCESS);
        this.result = result;
    }

    public SuccessResponse() {
        super(SUCCESS);
    }
}
