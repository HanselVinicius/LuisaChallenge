package com.vinicius.challenge.core.application.client

import com.vinicius.challenge.core.application.client.gateway.GetClientByIdGateway
import com.vinicius.challenge.core.domain.client.Client
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import kotlin.test.assertNotNull

class GetClientByIdUseCaseTest {

    @Test
    fun shouldCallGatewayToGetClientById() {
        // arrange
        val id = 1L
        val client = mock<Client>()
        val gateway = mock<GetClientByIdGateway> {
            on { getClientById(id) } doReturn client
        }
        val getClientByIdUseCase = GetClientByIdUseCase(gateway)

        // act
        val result = getClientByIdUseCase.getClientById(id)

        // assert
        assertNotNull(result)
    }
}
