package com.yoonNeun.MyDreamPartner.common.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
@JsonPropertyOrder({"isSuccess", "code", "message"})
public class BaseResponse {

    private final Boolean isSuccess;

    private final int code;

    private final String message;

    public BaseResponse(ResponseEnum status) {
        this.isSuccess = status.isSuccess();
        this.code = status.getCode();
        this.message = status.getMessage();
    }
}
