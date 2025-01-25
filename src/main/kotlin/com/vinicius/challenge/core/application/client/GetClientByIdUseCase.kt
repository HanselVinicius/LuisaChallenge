package com.vinicius.challenge.core.application.client

import com.vinicius.challenge.core.application.client.gateway.GetClientByIdGateway
import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.core.domain.client.service.GetClientByIdService

class GetClientByIdUseCase(private val getClientByIdGateway: GetClientByIdGateway) : GetClientByIdService {
    override fun getClientById(id: Long): Client {
        return getClientByIdGateway.getClientById(id)
    }
}
