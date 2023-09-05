package com.crater.backoffice.exception;

import com.crater.backoffice.bean.response.BaseResponse;
import com.crater.backoffice.bean.response.ErrorMessage;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler({DBOperationsException.class})
    @ResponseBody
    public BaseResponse handleDBOperationsException(Throwable e, RedirectAttributes redirectAttributes) {
        return new BaseResponse().setErrorMessage(new ErrorMessage().setSuccess(false)
                .setErrorMessage("發生內部邏輯錯誤，請聯絡開發人員。"));
    }

    @ExceptionHandler({UserException.class})
    @ResponseBody
    public BaseResponse handleOtherCustomException(Throwable e, RedirectAttributes redirectAttributes) {
        return new BaseResponse().setErrorMessage(new ErrorMessage().setSuccess(false).setErrorMessage(e.getMessage()));
    }

    @ExceptionHandler({Exception.class, RuntimeException.class})
    @ResponseBody
    public BaseResponse handleOtherUnknownException(Throwable e, RedirectAttributes redirectAttributes) {
        return new BaseResponse().setErrorMessage(new ErrorMessage().setSuccess(false)
                .setErrorMessage("發生未知錯誤，請聯絡開發人員。"));
    }
}
