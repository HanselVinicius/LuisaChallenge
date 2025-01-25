package com.vinicius.challenge.core.application.client.gateway

import com.vinicius.challenge.core.domain.client.Client

interface GetClientByIdGateway {
    fun getClientById(id: Long): Client
}
