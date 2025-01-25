package com.vinicius.challenge.core.domain.client.service

import com.vinicius.challenge.core.domain.client.Client

interface GetClientByIdService {
    fun getClientById(id: Long): Client
}
