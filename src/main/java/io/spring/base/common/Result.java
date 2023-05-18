package io.spring.base.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {
    private int status;
    private String message;
    private Object data;
    private Object page;

    public Result() {
        this.status = HttpStatus.OK.value();
        this.message = HttpStatus.OK.getReasonPhrase();
    }

    public Result(Object data) {
        this.status = HttpStatus.OK.value();
        this.message = HttpStatus.OK.getReasonPhrase();
        this.data = data;
    }

    public Result(Object data, Object page) {
        this.status = HttpStatus.OK.value();
        this.message = HttpStatus.OK.getReasonPhrase();
        this.data = data;
        this.page = page;
    }

    public Result(HttpStatus httpStatus){
        this.status = httpStatus.value();
        this.message = httpStatus.getReasonPhrase();
    }
}