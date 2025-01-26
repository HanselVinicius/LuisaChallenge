package com.vinicius.challenge.configuration.client

import com.vinicius.challenge.core.application.client.gateway.InsertClientGateway
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock

class InsertClientConfigTest {

    @Test
    fun testInsertClientService() {
        // arrange
        val insertClientGateway = mock<InsertClientGateway>()
        val insertClientConfig = InsertClientConfig()
        // act
        val result = insertClientConfig.insertClientService(insertClientGateway)
        // assert
        assertNotNull(result)
    }
}
