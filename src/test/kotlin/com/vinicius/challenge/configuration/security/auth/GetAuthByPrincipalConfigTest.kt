package com.vinicius.challenge.configuration.security.auth

import com.vinicius.challenge.core.application.auth.gateway.GetAuthByPrincipalGateway
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock

class GetAuthByPrincipalConfigTest {
    @Test
    fun shouldCreateGetAuthByPrincipalServiceBean() {
        // Arrange
        val getAuthByPrincipalConfig = GetAuthByPrincipalConfig()
        val getAuthByPrincipalGateway = mock<GetAuthByPrincipalGateway>()
        // Act
        val result = getAuthByPrincipalConfig.getAuthByPrincipalService(getAuthByPrincipalGateway)
        // Assert
        assertNotNull(result)
    }
}
