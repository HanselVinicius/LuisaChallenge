package com.vinicius.challenge.gateway.client

import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.gateway.client.entity.ClientEntity
import com.vinicius.challenge.gateway.client.entity.ClientEntityMapper
import com.vinicius.challenge.gateway.client.entity.ClientEntityRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
class InsertClientGatewayImplTest {

    @Test
    fun shouldReturnClientAfterInsertion() {
        // arrange
        val auth = Auth(0, "vinicius@gmail.com", "123456", true)
        val client = Client(1, "vinicius", auth, null, true)
        val clientEntity = ClientEntityMapper.toEntity(client)
        val clientEntityRepository = mock(ClientEntityRepository::class.java)
        val insertClientGateway = InsertClientGatewayImpl(clientEntityRepository)
        val captor = ArgumentCaptor.forClass(ClientEntity::class.java)
        `when`(clientEntityRepository.save(captor.capture())).thenReturn(clientEntity)
        // act
        val result = insertClientGateway.insertClient(client)
        // assert
        verify(clientEntityRepository).save(captor.capture())
        assertEquals(client.id, result.id)
    }
}
