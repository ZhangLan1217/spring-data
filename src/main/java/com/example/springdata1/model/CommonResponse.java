package com.example.springdata1.model;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommonResponse<T> {

    private int code;

    private String message;

    private T data;

    public static <T> CommonResponse ok(T data) {
        return new CommonResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), data);
    }

    public static CommonResponse ok() {
        return new CommonResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), null);
    }

    public static CommonResponse<ErrorResult> error(ErrorResult result) {
        return new CommonResponse(result.getStatus(), result.getErrorMessage(), result);
    }

    public static CommonResponse<ErrorResult> error(HttpStatus httpStatus) {
        return new CommonResponse(httpStatus.value(), httpStatus.getReasonPhrase(), null);
    }
}