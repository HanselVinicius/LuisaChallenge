package com.vinicius.challenge.core.application.auth

import com.vinicius.challenge.core.application.auth.gateway.GetAuthByPrincipalGateway
import com.vinicius.challenge.core.domain.auth.Auth
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class GetAuthByPrincipalUseCaseTest {
    @Test
    fun shouldCallGatewayToGetAuthByPrincipal() {
        // arrange
        val principal = "principal"
        val auth = Auth(1, "principal", "credentials", true)
        val getAuthByPrincipalGateway = mock(GetAuthByPrincipalGateway::class.java)
        val getAuthByPrincipalUseCase = GetAuthByPrincipalUseCase(getAuthByPrincipalGateway)

        // act
        `when`(getAuthByPrincipalGateway.getAuthByPrincipal(principal)).thenReturn(auth)
        val result = getAuthByPrincipalUseCase.getAuthByPrincipal(principal)
        // assert
        assertEquals(auth, result)
    }
}
