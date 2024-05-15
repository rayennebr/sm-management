package com.rayennebr.smmanagement.errorHandlers;

import com.rayennebr.smmanagement.dtos.Response;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class RestErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public Response<Object> handleNoSuchElementException(HttpServletRequest request,NoSuchElementException noSuchElementException)
    {
       log.error("error in request {}",request.getRequestURI());
        return  Response.builder()
                .status(HttpStatus.NOT_FOUND)
                .message("no element returned by your request "+request.getRequestURI())
                .data(null)
                .build();
    }

    @ExceptionHandler(GenericException.class)
    public Response<Object>handleGenericException(HttpServletRequest request ,GenericException exception)
    {
        log.error("error in request {}",request.getRequestURI());
        return  Response.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(exception.getMessage()+" catched in "+request.getRequestURI())
                .data(null)
                .build();
    }

    @ExceptionHandler(Exception.class)
    public Response<Object>handleException(HttpServletRequest request ,Exception exception)
    {
        log.error("error in request {}",request.getRequestURI());
        return  Response.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(exception.getMessage()+" catched in "+request.getRequestURI())
                .data(null)
                .build();
    }
}
