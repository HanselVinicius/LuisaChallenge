package com.vinicius.challenge.core.application.auth.gateway

interface LoginAuthGateway {
    fun login(principal: String, credentials: String): String
}
