package com.vinicius.challenge.gateway.client

import com.vinicius.challenge.core.application.client.gateway.GetClientByIdGateway
import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.gateway.client.entity.ClientEntityMapper
import com.vinicius.challenge.gateway.client.entity.ClientEntityRepository
import org.springframework.stereotype.Component

@Component
class GetClientByIdGatewayImpl(private val clientEntityRepository: ClientEntityRepository) : GetClientByIdGateway {
    override fun getClientById(id: Long): Client {
        val clientEntity = clientEntityRepository.findById(id).orElseThrow { throw IllegalArgumentException("Client not found") }
        return ClientEntityMapper.toDomain(clientEntity)
    }
}
