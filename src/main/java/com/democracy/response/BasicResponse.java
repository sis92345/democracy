package com.democracy.response;

import org.springframework.http.HttpStatus;

import java.util.List;

public class BasicResponse {
    private Integer code;
    private HttpStatus httpStatus;
    private String message;
    private Integer count;
    private List<?> result;

    public static BasicResponseBuilder builder() {
        return new BasicResponseBuilder();
    }

    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
    public List<?> getResult() {
        return result;
    }
    public void setResult(List<?> result) {
        this.result = result;
    }
}
