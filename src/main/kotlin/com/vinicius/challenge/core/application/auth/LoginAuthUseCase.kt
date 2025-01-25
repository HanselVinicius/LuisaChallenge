package com.vinicius.challenge.core.application.auth

import com.vinicius.challenge.core.application.auth.gateway.LoginAuthGateway
import com.vinicius.challenge.core.domain.auth.dto.LoginDto
import com.vinicius.challenge.core.domain.auth.service.LoginAuthService
import com.vinicius.challenge.core.domain.client.service.FindClientByPrincipalService

class LoginAuthUseCase(private val loginAuthGateway: LoginAuthGateway, private val findClientByPrincipalService: FindClientByPrincipalService) : LoginAuthService {
    override fun login(principal: String, credentials: String): LoginDto {
        val token = loginAuthGateway.login(principal, credentials)
        val client = findClientByPrincipalService.findClientByPrincipal(principal)
        return LoginDto(token, client!!)
    }
}
