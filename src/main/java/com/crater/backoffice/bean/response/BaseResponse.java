package com.crater.backoffice.bean.response;

public class BaseResponse {
    private ErrorMessage errorMessage;

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public BaseResponse setErrorMessage(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }
}
