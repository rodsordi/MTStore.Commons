package br.com.mt.commons.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class RestException extends RuntimeException {

    @Getter
    private final HttpStatus httpStatus;

    public RestException(HttpStatus httpStatus) {
        super(httpStatus.getReasonPhrase());
        this.httpStatus = httpStatus;
    }

}