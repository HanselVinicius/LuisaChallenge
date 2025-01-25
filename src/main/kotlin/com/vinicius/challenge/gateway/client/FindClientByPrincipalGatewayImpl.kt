package com.vinicius.challenge.gateway.client

import com.vinicius.challenge.core.application.client.gateway.FindClientByPrincipalGateway
import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.gateway.client.entity.ClientEntityMapper
import com.vinicius.challenge.gateway.client.entity.ClientEntityRepository
import org.springframework.stereotype.Component

@Component
class FindClientByPrincipalGatewayImpl(private val clientEntityRepository: ClientEntityRepository) : FindClientByPrincipalGateway {
    override fun findClientByPrincipal(principal: String): Client? {
        val clientEntity = clientEntityRepository.findByAuthPrincipal(principal) ?: return null
        return ClientEntityMapper.toDomain(clientEntity)
    }
}
