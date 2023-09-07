package com.crater.backoffice.exception;

import java.util.List;

public class RequestDataException extends RuntimeException {
    List<String> nullKeyList;

    public RequestDataException(String message) {
        super(message);
    }

    public RequestDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestDataException(List<String> nullKeyList) {
        super((nullKeyList == null || nullKeyList.isEmpty()) ? "request have error" : String.join(", ", nullKeyList) + " 不可為空");
    }
}
