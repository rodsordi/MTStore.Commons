package br.com.mt.store.commons.app.config;

import br.com.mt.store.commons.app.dto.ResponseErrorDTO;
import br.com.mt.store.commons.app.exception.RestException;
import br.com.mt.store.commons.domain.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionConfig extends ResponseEntityExceptionHandler {

    private static final String INTERNAL_ERROR = "Internal Error";

    @ExceptionHandler(RestException.class)
    public ResponseEntity restException(RestException e, WebRequest request){
        log.warn(e.getMessage());
        var builder = new ResponseErrorDTO.Builder()
                .addErro(e.getMessage());
        return new ResponseEntity(builder.build(), e.getHttpStatus());
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity missingRequestHeaderException(MissingRequestHeaderException e, WebRequest request){
        log.warn(e.getMessage());
        var builder = new ResponseErrorDTO.Builder()
                .addErro(e.getMessage());
        return new ResponseEntity(builder.build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity businessException(BusinessException e, WebRequest request){
        log.warn(e.getMessage());
        var builder = new ResponseErrorDTO.Builder();
        e.getErrorMessages()
                .forEach(mensagemDeErro -> builder.addErro(mensagemDeErro));
        return new ResponseEntity(builder.build(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var builder = new ResponseErrorDTO.Builder();
        ex.getBindingResult().getAllErrors()
                .forEach(erro -> builder.addErro(erro.getDefaultMessage()));
        var response = builder.build();
        log.warn(response.getErro());
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity runtimeException(RuntimeException e, WebRequest request) {
        log.error(e.getMessage(), e);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(INTERNAL_ERROR);
    }

}