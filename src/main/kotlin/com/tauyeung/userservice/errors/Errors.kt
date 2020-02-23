package com.tauyeung.userservice.errors

import org.springframework.http.HttpStatus
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.HashMap

/*
    TODO

    Learn about error handling

    - http://www.appsdeveloperblog.com/validate-request-body-in-restful-web-service/
    - https://mkyong.com/spring-boot/spring-rest-validation-example/
    - https://www.baeldung.com/spring-boot-bean-validation
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
@ExceptionHandler(MethodArgumentNotValidException::class)
fun handleValidationExceptions(ex: MethodArgumentNotValidException): Map<String, String?> {
    val errors = HashMap<String, String?>()
    ex
        .bindingResult
        .allErrors
        .forEach {
            val fieldName = (it as FieldError).field
            val errorMessage = it.getDefaultMessage()
            errors[fieldName] = errorMessage
        }
    return errors
}
