package com.vinicius.challenge.configuration.security.auth

import com.vinicius.challenge.core.application.auth.gateway.LoginAuthGateway
import com.vinicius.challenge.core.domain.client.service.FindClientByPrincipalService
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock

class LoginAuthConfigTest {

    @Test
    fun testLoginAuthService() {
        // arrange
        val loginAuthConfig = LoginAuthConfig()
        val loginAuthGateway = mock<LoginAuthGateway>()
        val findClientByPrincipalService = mock<FindClientByPrincipalService>()
        // act
        val result = loginAuthConfig.loginAuthService(loginAuthGateway, findClientByPrincipalService)
        // assert
        assertNotNull(result)
    }
}
