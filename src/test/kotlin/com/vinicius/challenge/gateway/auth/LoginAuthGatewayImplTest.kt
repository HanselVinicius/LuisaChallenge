package com.vinicius.challenge.gateway.auth

import com.vinicius.challenge.configuration.security.SecurityProperties
import com.vinicius.challenge.gateway.auth.entity.AuthEntity
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication

class LoginAuthGatewayImplTest {
    @Test
    fun shouldReturnTokenWhenLogin() {
        // arrange
        val principal = "test"
        val credentials = "test"
        val authenticationManager = mock(AuthenticationManager::class.java)
        val securityProperties = mock(SecurityProperties::class.java)
        val secret = "testSecret"
        val issuer = "testIssuer"
        val authentication = mock(Authentication::class.java)
        `when`(securityProperties.secret).thenReturn(secret)
        `when`(securityProperties.issuer).thenReturn(issuer)
        `when`(authentication.principal).thenReturn(AuthEntity(id = 0, principal = principal, credentials = credentials, true))
        `when`(authenticationManager.authenticate(UsernamePasswordAuthenticationToken(principal, credentials))).thenReturn(authentication)
        val authManagerGateway = AuthManagerGateway(authenticationManager, securityProperties)
        // act
        val token = authManagerGateway.authenticate(principal, credentials)
        // assert
        assertNotNull(token)
    }
}
