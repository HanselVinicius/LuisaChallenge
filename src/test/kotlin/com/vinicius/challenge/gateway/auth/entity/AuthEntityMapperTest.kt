package com.vinicius.challenge.gateway.auth.entity

import com.vinicius.challenge.core.domain.auth.Auth
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AuthEntityMapperTest {
    @Test
    fun shouldReturnAuthDomainWithAuthEntity() {
        // arrange
        val principal = "principal"
        val credentials = "credentials"
        val authEntity = AuthEntity(1, principal, credentials, true)
        // act
        val auth = AuthEntityMapper.toDomain(authEntity)
        // assert
        assertEquals(authEntity.id, auth.id)
        assertEquals(authEntity.principal, auth.principal)
        assertEquals(authEntity.credentials, auth.credentials)
    }

    @Test
    fun shouldReturnAuthEntityWithAuthDomain() {
        // arrange
        val principal = "principal"
        val credentials = "credentials"
        val auth = Auth(1, principal, credentials, true)
        // act
        val authEntity = AuthEntityMapper.toEntity(auth)
        // assert
        assertEquals(auth.id, authEntity.id)
        assertEquals(auth.principal, authEntity.principal)
        assertEquals(auth.credentials, authEntity.credentials)
    }
}
