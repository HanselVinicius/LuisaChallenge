package com.vinicius.challenge.configuration.client

import com.vinicius.challenge.core.application.client.gateway.FindClientByPrincipalGateway
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock

class FindClientByPrincipalConfigTest {

    @Test
    fun testFindClientByPrincipalService() {
        // arrange
        val findClientByPrincipalGateway = mock<FindClientByPrincipalGateway>()
        val findClientByPrincipalConfig = FindClientByPrincipalConfig()

        // act
        val result = findClientByPrincipalConfig.findClientByPrincipalService(findClientByPrincipalGateway)

        // assert
        assertNotNull(result)
    }
}
