package com.vinicius.challenge.gateway.auth

import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.gateway.auth.entity.AuthEntity
import com.vinicius.challenge.gateway.auth.entity.AuthEntityRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class GetAuthByPrincipalGatewayImplTest {

    @Test
    fun shouldReturnAuthByPrincipal() {
        // arrange
        val principal = "principal"
        val credentials = "credentials"
        val auth = Auth(1, principal, credentials, true)

        val authEntity = AuthEntity(1, principal = principal, credentials = credentials, true)
        val authEntityRepository = mock(AuthEntityRepository::class.java)
        // act
        `when`(authEntityRepository.findByPrincipal(principal)).thenReturn(authEntity)
        val getAuthByPrincipalGateway = GetAuthByPrincipalGatewayImpl(authEntityRepository)
        val result = getAuthByPrincipalGateway.getAuthByPrincipal(principal)

        // assert
        assertEquals(auth.id, result?.id)
        assertEquals(auth.principal, result?.principal)
        assertEquals(auth.credentials, result?.credentials)
    }

    @Test
    fun shouldLoadUserByUserName() {
        // arrange
        val principal = "principal"
        val credentials = "credentials"

        val authEntity = AuthEntity(1, principal = principal, credentials = credentials, true)
        val authEntityRepository = mock(AuthEntityRepository::class.java)
        // act
        `when`(authEntityRepository.findByPrincipal(principal)).thenReturn(authEntity)
        val getAuthByPrincipalGateway = GetAuthByPrincipalGatewayImpl(authEntityRepository)
        val result = getAuthByPrincipalGateway.loadUserByUsername(principal)

        // assert
        assertEquals(authEntity, result)
    }

    @Test
    fun shouldReturnNullWhenPrincipalNotFound() {
        // arrange
        val principal = "principal"
        val authEntityRepository = mock(AuthEntityRepository::class.java)
        // act
        `when`(authEntityRepository.findByPrincipal(principal)).thenReturn(null)
        val getAuthByPrincipalGateway = GetAuthByPrincipalGatewayImpl(authEntityRepository)
        val result = getAuthByPrincipalGateway.getAuthByPrincipal(principal)

        // assert
        assertEquals(null, result)
    }
}
