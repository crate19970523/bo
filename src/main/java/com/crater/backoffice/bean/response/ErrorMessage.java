package com.crater.backoffice.bean.response;

import io.swagger.v3.oas.annotations.media.Schema;

public class ErrorMessage {
    @Schema(example = "true", description = "用來說明處理是否成功")
    private Boolean isSuccess;
    @Schema(example = "", description = "說明錯誤原因")
    private String errorMessage;

    public Boolean getSuccess() {
        return isSuccess;
    }

    public ErrorMessage setSuccess(Boolean success) {
        isSuccess = success;
        return this;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public ErrorMessage setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }
}
