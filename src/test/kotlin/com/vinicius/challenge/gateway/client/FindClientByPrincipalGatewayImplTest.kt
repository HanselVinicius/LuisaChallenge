package com.vinicius.challenge.gateway.client

import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.gateway.auth.entity.AuthEntity
import com.vinicius.challenge.gateway.client.entity.ClientEntity
import com.vinicius.challenge.gateway.client.entity.ClientEntityRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import kotlin.test.Test

class FindClientByPrincipalGatewayImplTest {

    @Test
    fun shouldReturnClientWhenPrincipalExists() {
        // Arrange
        val principal = "testPrincipal"
        val authEntity = AuthEntity(id = 1, principal = principal, credentials = "password", enabled = true)
        val clientEntity = ClientEntity(
            id = 1,
            name = "Test Client",
            auth = authEntity,
            favoriteLists = mutableListOf(),
            enabled = true
        )

        val client = Client(id = 1, name = "Test Client", auth = Auth(id = 1, principal = principal, credentials = "password", enabled = true), enabled = true)
        val mockClientEntityRepository = mock(ClientEntityRepository::class.java)
        `when`(mockClientEntityRepository.findByAuthPrincipal(principal)).thenReturn(clientEntity)

        val findClientByPrincipalGateway = FindClientByPrincipalGatewayImpl(mockClientEntityRepository)

        // Act
        val result = findClientByPrincipalGateway.findClientByPrincipal(principal)

        // Assert
        assertEquals(client.id, result?.id)

        verify(mockClientEntityRepository).findByAuthPrincipal(principal)
    }
}
