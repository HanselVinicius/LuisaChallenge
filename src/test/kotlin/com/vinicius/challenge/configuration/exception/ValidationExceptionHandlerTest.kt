package com.vinicius.challenge.configuration.exception

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException

class ValidationExceptionHandlerTest {

    @Test
    fun shouldHandleMethodArgumentNotValidException() {
        // Arrange
        val validationExceptionHandler = ValidationExceptionHandler()

        val fieldError1 = FieldError("objectName", "field1", "Field 1 is required")
        val fieldError2 = FieldError("objectName", "field2", "Field 2 is invalid")
        val bindingResult = mock<BindingResult> {
            on { fieldErrors } doReturn listOf(fieldError1, fieldError2)
        }
        val exception = MethodArgumentNotValidException(mock(), bindingResult)

        // Act
        val response: ResponseEntity<List<ExceptionDto>> = validationExceptionHandler.handleValidationExceptions(exception)

        // Assert
        assertNotNull(response)
        assertEquals(HttpStatus.BAD_REQUEST, response.statusCode)
        assertEquals(2, response.body?.size)
        assertEquals("field1: Field 1 is required", response.body?.get(0)?.message)
        assertEquals("field2: Field 2 is invalid", response.body?.get(1)?.message)
    }

    @Test
    fun shouldHandleSecurityException() {
        // Arrange
        val validationExceptionHandler = ValidationExceptionHandler()
        val exception = SecurityException("Access Denied")

        // Act
        val response: ResponseEntity<ExceptionDto> = validationExceptionHandler.handleSecurityException(exception)

        // Assert
        assertNotNull(response)
        assertEquals(HttpStatus.FORBIDDEN, response.statusCode)
        assertEquals("Access Denied", response.body?.message)
    }

    @Test
    fun shouldHandleIllegalArgumentException() {
        // Arrange
        val validationExceptionHandler = ValidationExceptionHandler()
        val exception = IllegalArgumentException("Invalid Argument")

        // Act
        val response: ResponseEntity<ExceptionDto> = validationExceptionHandler.handleIllegalArgumentException(exception)

        // Assert
        assertNotNull(response)
        assertEquals(HttpStatus.BAD_REQUEST, response.statusCode)
        assertEquals("Invalid Argument", response.body?.message)
    }

    @Test
    fun shouldHandleIllegalArgumentExceptionWithNullMessage() {
        // Arrange
        val validationExceptionHandler = ValidationExceptionHandler()
        val exception = IllegalArgumentException()

        // Act
        val response: ResponseEntity<ExceptionDto> = validationExceptionHandler.handleIllegalArgumentException(exception)

        // Assert
        assertNotNull(response)
        assertEquals(HttpStatus.BAD_REQUEST, response.statusCode)
        assertEquals("Unexpected error", response.body?.message)
    }
}
