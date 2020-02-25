package com.tauyeung.user.api.errors

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

import java.util.stream.Collectors

/*
    TODO

    Learn about error handling

    - http://www.appsdeveloperblog.com/validate-request-body-in-restful-web-service/
    - https://mkyong.com/spring-boot/spring-rest-validation-example/
    - https://www.baeldung.com/spring-boot-bean-validation
 */

@ControllerAdvice
@RestController
public class ExceptionHandler : ResponseEntityExceptionHandler() {
    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        val errorList = ex
            .getBindingResult()
            .getFieldErrors()
            .stream()
            .map({ it.getDefaultMessage() })
            .collect(Collectors.toList());
        val errorDetails = ErrorDetails(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errorList);
        return handleExceptionInternal(ex, errorDetails, headers, errorDetails.status, request);
    }
}

data class ErrorDetails(val status: HttpStatus, val message: String, val errors: MutableList<String?>)