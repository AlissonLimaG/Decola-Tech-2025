package com.padrao.mvc.mvc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.padrao.mvc.mvc.exceptions.exceptionResponseDesign.ErrorResponse;
import com.padrao.mvc.mvc.models.product.exceptions.ProductInvalidPriceException;
import com.padrao.mvc.mvc.models.product.exceptions.ProductNullNameException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(exception = Exception.class)
    public ResponseEntity<ErrorResponse> valorInvalido(ProductInvalidPriceException ex) {
        ErrorResponse err = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.badRequest().body(err);
    }

    @ExceptionHandler(exception = ProductNullNameException.class)
    public ResponseEntity<ErrorResponse> nomeInvalido(ProductNullNameException ex) {
        ErrorResponse err = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.badRequest().body(err);
    }

}
