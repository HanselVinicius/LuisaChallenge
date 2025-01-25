package com.vinicius.challenge.entrypoint.auth

import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.core.domain.auth.dto.LoginDto
import com.vinicius.challenge.core.domain.auth.service.InsertAuthService
import com.vinicius.challenge.core.domain.auth.service.LoginAuthService
import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.core.domain.client.service.InsertClientService
import com.vinicius.challenge.entrypoint.auth.dto.AuthDto
import com.vinicius.challenge.entrypoint.auth.dto.RegisterDto
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.springframework.http.HttpStatus
import kotlin.test.assertEquals

class AuthControllerTest {

    @Test
    fun shouldCallAuthServiceToInsertClient() {
        // Arrange
        val authDto = RegisterDto("username@gmail.com", "password", "name")

        val insertAuthService = mock<InsertAuthService> {
            on { insertAuth(any()) } doReturn Auth(1, authDto.principal, authDto.credentials, true)
        }

        val authInserted = Auth(1, authDto.principal, authDto.credentials, true)

        val loginAuthService = mock<LoginAuthService> {
            on { login(authDto.principal, authDto.credentials) } doReturn LoginDto("token", Client(1, authDto.name, authInserted, null, true))
        }
        val insertClientService = mock<InsertClientService>() {
            on { insertClient(any()) } doReturn Client(1, authDto.name, authInserted, null, true)
        }

        val authController = AuthController(insertAuthService, loginAuthService, insertClientService)

        // Act
        val response = authController.insertClient(authDto)

        // Assert
        assertEquals(HttpStatus.OK, response.statusCode)

        assertNotNull(authInserted.id)
    }

    @Test
    fun shouldCallServiceToLogin() {
        // arrange
        val principal = "vinicius@gmail.com"
        val credentials = "credentials"
        val authDto = AuthDto(principal, credentials)
        val insertAuthService = mock<InsertAuthService>()
        val loginAuthService = mock<LoginAuthService> {
            on { login(principal, credentials) } doReturn LoginDto("token", Client(1, "test", Auth(0, principal, credentials, true), null, true))
        }
        val insertClientService = mock<InsertClientService> {
            on { insertClient(any()) } doReturn Client(1, "test", Auth(0, principal, credentials, true), null, true)
        }
        val authController = AuthController(insertAuthService, loginAuthService, insertClientService)
        // act
        val response = authController.login(authDto)

        // assert
        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals("token", response.body?.token)
    }
}
