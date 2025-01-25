package com.vinicius.challenge.core.domain.client.service

import com.vinicius.challenge.core.domain.client.Client

interface InsertClientService {
    fun insertClient(client: Client): Client
}
