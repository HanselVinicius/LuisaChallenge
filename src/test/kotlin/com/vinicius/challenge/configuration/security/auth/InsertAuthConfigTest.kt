package com.vinicius.challenge.configuration.security.auth

import com.vinicius.challenge.core.application.auth.gateway.InsertAuthGateway
import com.vinicius.challenge.core.domain.auth.service.GetAuthByPrincipalService
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock

class InsertAuthConfigTest {
    @Test
    fun testInsertAuthService() {
        // arrange
        val insertAuthConfig = InsertAuthConfig()
        val insertAuthGateway = mock<InsertAuthGateway>()
        val getAuthByPrincipalService = mock<GetAuthByPrincipalService>()
        // act
        val result = insertAuthConfig.insertAuthService(insertAuthGateway, getAuthByPrincipalService)
        // assert
        assertNotNull(result)
    }
}
