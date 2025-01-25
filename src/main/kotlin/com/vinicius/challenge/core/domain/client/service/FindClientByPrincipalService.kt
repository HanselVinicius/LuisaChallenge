package com.vinicius.challenge.core.domain.client.service

import com.vinicius.challenge.core.domain.client.Client

interface FindClientByPrincipalService {
    fun findClientByPrincipal(principal: String): Client?
}
