package com.democracy.response;

import org.springframework.http.HttpStatus;

import java.util.List;

public class BasicResponseBuilder {
    private Integer code;
    private HttpStatus httpStatus;
    private String message;
    private Integer count;
    private List<?> result;

    public BasicResponse build() {
        BasicResponse br = new BasicResponse();
        br.setCode(this.code);
        br.setHttpStatus(this.httpStatus);
        br.setMessage(this.message);
        br.setCount(this.count);
        br.setResult(this.result);
        return br;
    }

    public BasicResponseBuilder code(Integer code) {
        this.code = code;
        return this;
    }
    public BasicResponseBuilder httpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }
    public BasicResponseBuilder message(String message) {
        this.message = message;
        return this;
    }
    public BasicResponseBuilder count(Integer count) {
        this.count = count;
        return this;
    }
    public BasicResponseBuilder result(List<?> result) {
        this.result = result;
        return this;
    }
}
