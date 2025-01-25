package com.vinicius.challenge.core.application.client

import com.vinicius.challenge.core.application.client.gateway.FindClientByPrincipalGateway
import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.core.domain.client.Client
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class FindClientByPrincipalUseCaseTest {
    @Test
    fun shouldReturnClientByPrincipal() {
        // arrange
        val email = "vinicius@gmail.com"
        val auth = Auth(0, email, "123456", true)
        val client = Client(1, "Vinicius", auth, null, true)
        val findClientByPrincipalGateway = mock(FindClientByPrincipalGateway::class.java)
        `when`(findClientByPrincipalGateway.findClientByPrincipal(email)).thenReturn(client)
        val findClientByPrincipalUseCase = FindClientByPrincipalUseCase(findClientByPrincipalGateway)
        // act
        val clientFound = findClientByPrincipalUseCase.findClientByPrincipal(email)
        // assert
        assertEquals(email, clientFound?.auth?.principal)
    }
}
