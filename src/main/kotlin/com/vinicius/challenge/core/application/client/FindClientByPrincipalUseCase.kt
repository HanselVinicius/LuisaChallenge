package com.vinicius.challenge.core.application.client

import com.vinicius.challenge.core.application.client.gateway.FindClientByPrincipalGateway
import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.core.domain.client.service.FindClientByPrincipalService

class FindClientByPrincipalUseCase(private val findClientByPrincipalGateway: FindClientByPrincipalGateway) : FindClientByPrincipalService {
    override fun findClientByPrincipal(principal: String): Client? {
        return findClientByPrincipalGateway.findClientByPrincipal(principal)
    }
}
