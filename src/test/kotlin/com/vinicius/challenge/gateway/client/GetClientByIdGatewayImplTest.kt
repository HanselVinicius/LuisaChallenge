package com.vinicius.challenge.gateway.client

import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.gateway.auth.entity.AuthEntity
import com.vinicius.challenge.gateway.client.entity.ClientEntity
import com.vinicius.challenge.gateway.client.entity.ClientEntityRepository
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.util.*

class GetClientByIdGatewayImplTest {

    @Test
    fun shouldReturnClientWhenFoundById() {
        // Arrange
        val clientId = 1L
        val authEntity = AuthEntity(
            id = 1,
            principal = "principal",
            credentials = "credentials",
            enabled = true
        )
        val clientEntity = ClientEntity(
            id = clientId,
            name = "client",
            auth = authEntity,
            favoriteListEntity = null,
            enabled = true
        )
        val auth = Auth(1, "principal", "credentials", true)

        val clientEntityRepository = mock<ClientEntityRepository> {
            whenever(it.findById(clientId)).thenReturn(Optional.of(clientEntity))
        }

        val gateway = GetClientByIdGatewayImpl(clientEntityRepository)

        val expectedClient = Client(
            id = clientId,
            name = "client",
            auth = auth,
            favoriteList = null,
            enabled = true
        )

        // Act
        val client = gateway.getClientById(clientId)

        // Assert
        assertNotNull(client)
    }

    @Test
    fun shouldThrowExceptionWhenClientNotFoundById() {
        // Arrange
        val clientId = 999L
        val clientEntityRepository = mock<ClientEntityRepository> {
            whenever(it.findById(clientId)).thenReturn(Optional.empty())
        }

        val gateway = GetClientByIdGatewayImpl(clientEntityRepository)

        // Act & Assert
        assertThrows<IllegalArgumentException> {
            gateway.getClientById(clientId)
        }
    }
}
