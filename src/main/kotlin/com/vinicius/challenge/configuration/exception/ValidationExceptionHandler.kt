package com.vinicius.challenge.configuration.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(ex: MethodArgumentNotValidException): ResponseEntity<List<ExceptionDto>> {
        val errors = mutableListOf<ExceptionDto>()

        for (error in ex.bindingResult.fieldErrors) {
            errors.add(ExceptionDto(("${error.field}: " + error.defaultMessage)))
        }

        return ResponseEntity(errors, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(SecurityException::class)
    fun handleSecurityException(ex: SecurityException): ResponseEntity<ExceptionDto> {
        return ResponseEntity(ExceptionDto(ex.message ?: "Unexpected error"), HttpStatus.FORBIDDEN)
    }
}
