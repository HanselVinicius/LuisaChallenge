package com.vinicius.challenge.gateway.auth

import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.gateway.auth.entity.AuthEntity
import com.vinicius.challenge.gateway.auth.entity.AuthEntityRepository
import org.junit.jupiter.api.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito.any
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

class InsertAuthGatewayImplTest {
    @Test
    fun shouldInsertAuth() {
        // arrange
        val principal = "principal"
        val credentials = "credentials"
        val auth = Auth(1, principal, credentials, true)

        val authEntity = AuthEntity(1, principal = principal, credentials = credentials, true)
        val authEntityRepository = mock(AuthEntityRepository::class.java)

        // act
        `when`(authEntityRepository.save(any(AuthEntity::class.java))).thenReturn(authEntity)

        val insertAuthGateway = InsertAuthGatewayImpl(authEntityRepository)
        insertAuthGateway.insertAuth(auth)

        // assert
        val captor = ArgumentCaptor.forClass(AuthEntity::class.java)
        verify(authEntityRepository).save(captor.capture())
        val capturedAuthEntity = captor.value
        assert(capturedAuthEntity.principal == authEntity.principal)
    }
}
