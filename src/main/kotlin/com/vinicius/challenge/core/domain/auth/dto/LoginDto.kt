package com.vinicius.challenge.core.domain.auth.dto

import com.vinicius.challenge.core.domain.client.Client

data class LoginDto(
    val token: String,
    val client: Client
)
