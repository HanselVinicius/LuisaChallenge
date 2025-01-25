package com.vinicius.challenge.core.application.client

import com.vinicius.challenge.core.application.client.gateway.InsertClientGateway
import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.core.domain.client.Client
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class InsertClientUseCaseTest {

    @Test
    fun shouldCallGatewayToInsertClient() {
        // arrange
        val auth = Auth(0, "vinicius@gmail.com", "123456", true)
        val client = Client(1, "Vinicius", auth, null, true)
        val gateway = mock(InsertClientGateway::class.java)
        val insertClientUseCase = InsertClientUseCase(gateway)
        // act
        insertClientUseCase.insertClient(client)
        // assert
        verify(gateway).insertClient(client)
    }
}
