package com.vinicius.challenge.core.application.client.gateway

import com.vinicius.challenge.core.domain.client.Client

interface InsertClientGateway {
    fun insertClient(client: Client): Client
}
