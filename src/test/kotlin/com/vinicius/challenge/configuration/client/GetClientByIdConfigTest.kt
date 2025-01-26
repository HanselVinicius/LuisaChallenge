package com.vinicius.challenge.configuration.client

import com.vinicius.challenge.core.application.client.gateway.GetClientByIdGateway
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock

class GetClientByIdConfigTest {

    @Test
    fun testGetClientByIdService() {
        // arrange
        val getClientByIdGateway = mock<GetClientByIdGateway>()
        val getClientByIdConfig = GetClientByIdConfig()

        // act
        val result = getClientByIdConfig.getClientByIdService(getClientByIdGateway)

        // assert
        assertNotNull(result)
    }
}
