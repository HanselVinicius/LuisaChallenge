package com.vinicius.challenge.core.application.auth

import com.vinicius.challenge.core.application.auth.gateway.InsertAuthGateway
import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.core.domain.auth.service.GetAuthByPrincipalService
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.never
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

class InsertAuthUseCaseTest {
    @Test
    fun shouldCallInsertAuthGatewayWithNotExistentEmail() {
        // arrange
        val insertAuthGateway = mock(InsertAuthGateway::class.java)
        val getAuthByPrincipalService = mock(GetAuthByPrincipalService::class.java)
        val insertAuthUseCase = InsertAuthUseCase(insertAuthGateway, getAuthByPrincipalService)
        val auth = Auth(1, "username", "password", true)
        `when`(getAuthByPrincipalService.getAuthByPrincipal("username")).thenReturn(null)
        // act
        insertAuthUseCase.insertAuth(auth)

        // assert
        verify(insertAuthGateway).insertAuth(auth)
    }

    @Test
    fun shouldThrowSecurityExceptionWhenUserAlreadyExists() {
        // arrange
        val insertAuthGateway = mock(InsertAuthGateway::class.java)
        val getAuthByPrincipalService = mock(GetAuthByPrincipalService::class.java)
        val insertAuthUseCase = InsertAuthUseCase(insertAuthGateway, getAuthByPrincipalService)
        val auth = Auth(1, "username", "password", true)

        `when`(getAuthByPrincipalService.getAuthByPrincipal("username")).thenReturn(auth)
        // act & assert
        assertThrows(SecurityException::class.java) {
            insertAuthUseCase.insertAuth(auth)
        }

        verify(insertAuthGateway, never()).insertAuth(auth)
    }
}
