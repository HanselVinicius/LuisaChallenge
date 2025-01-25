package com.vinicius.challenge.core.application.auth

import com.vinicius.challenge.core.application.auth.gateway.LoginAuthGateway
import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.core.domain.client.service.FindClientByPrincipalService
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class LoginAuthUseCaseTest {

    @Test
    fun shouldReturnTokenWhenLogin() {
        // arrange
        val principal = "test"
        val credentials = "test"
        val client = Client(1, "test", Auth(0, principal, credentials, true), null, true)
        val loginAuthGateway = mock(LoginAuthGateway::class.java)
        val findClientByPrincipalService = mock(FindClientByPrincipalService::class.java)
        val loginAuthUseCase = LoginAuthUseCase(loginAuthGateway, findClientByPrincipalService)
        `when`(loginAuthGateway.login(principal, credentials)).thenReturn("token")
        `when`(findClientByPrincipalService.findClientByPrincipal(principal)).thenReturn(client)
        // act
        val token = loginAuthUseCase.login(principal, credentials)
        // assert
        assertNotNull(token.token)
        assertNotNull(token.client)
    }
}
