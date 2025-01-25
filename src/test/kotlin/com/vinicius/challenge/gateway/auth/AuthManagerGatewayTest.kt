package com.vinicius.challenge.gateway.auth

import com.vinicius.challenge.configuration.security.SecurityProperties
import com.vinicius.challenge.gateway.auth.entity.AuthEntity
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.kotlin.any
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken

class AuthManagerGatewayTest {

    @Test
    fun shouldAuthenticateAndGenerateToken() {
        // arrange
        val principal = "testUser"
        val credentials = "testPassword"
        val mockAuthEntity = AuthEntity(0, principal, credentials, true)
        val mockAuthenticationManager = mock(AuthenticationManager::class.java)
        val mockSecurityProperties = mock(SecurityProperties::class.java)

        `when`(mockAuthenticationManager.authenticate(any())).thenReturn(
            UsernamePasswordAuthenticationToken(mockAuthEntity, null)
        )
        `when`(mockSecurityProperties.secret).thenReturn("mySecret")
        `when`(mockSecurityProperties.issuer).thenReturn("myIssuer")

        val authManagerGateway = AuthManagerGateway(mockAuthenticationManager, mockSecurityProperties)

        // act
        val token = authManagerGateway.authenticate(principal, credentials)

        // assert
        assertNotNull(token)
    }
}
