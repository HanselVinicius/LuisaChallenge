package com.vinicius.challenge.gateway.client

import com.vinicius.challenge.core.application.client.gateway.InsertClientGateway
import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.gateway.client.entity.ClientEntityMapper
import com.vinicius.challenge.gateway.client.entity.ClientEntityRepository
import org.springframework.stereotype.Component

@Component
class InsertClientGatewayImpl(private val clientEntityRepository: ClientEntityRepository) : InsertClientGateway {
    override fun insertClient(client: Client): Client {
        val clientEntity = clientEntityRepository.save(ClientEntityMapper.toEntity(client))
        return ClientEntityMapper.toDomain(clientEntity)
    }
}
