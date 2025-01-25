package com.vinicius.challenge.gateway.auth

import com.vinicius.challenge.core.application.auth.gateway.LoginAuthGateway
import org.springframework.stereotype.Component

@Component
class LoginAuthGatewayImpl(private val authManagerGateway: AuthManagerGateway) : LoginAuthGateway {
    override fun login(principal: String, credentials: String): String {
        return authManagerGateway.authenticate(principal, credentials)
    }
}
