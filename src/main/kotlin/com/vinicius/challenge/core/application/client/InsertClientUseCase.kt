package com.vinicius.challenge.core.application.client

import com.vinicius.challenge.core.application.client.gateway.InsertClientGateway
import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.core.domain.client.service.InsertClientService

class InsertClientUseCase(private val insertClientGateway: InsertClientGateway) : InsertClientService {
    override fun insertClient(client: Client): Client {
        return insertClientGateway.insertClient(client)
    }
}
