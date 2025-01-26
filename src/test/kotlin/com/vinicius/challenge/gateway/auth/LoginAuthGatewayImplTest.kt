package com.vinicius.challenge.gateway.auth

import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import kotlin.test.assertNotNull

class LoginAuthGatewayImplTest {
    @Test
    fun shouldReturnTokenWhenLogin() {
        // arrange
        val principal = "testUser"
        val credentials = "testPassword"
        val authMangerGateway = mock<AuthManagerGateway> {
            on { authenticate(principal, credentials) }.thenReturn("token")
        }
        val loginAuthGatewayImpl = LoginAuthGatewayImpl(authMangerGateway)
        // act
        val token = loginAuthGatewayImpl.login(principal, credentials)
        // assert
        assertNotNull(token)
    }
}
