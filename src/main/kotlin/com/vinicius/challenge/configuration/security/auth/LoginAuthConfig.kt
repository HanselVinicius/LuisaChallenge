package com.vinicius.challenge.configuration.security.auth

import com.vinicius.challenge.core.application.auth.LoginAuthUseCase
import com.vinicius.challenge.core.application.auth.gateway.LoginAuthGateway
import com.vinicius.challenge.core.domain.auth.service.LoginAuthService
import com.vinicius.challenge.core.domain.client.service.FindClientByPrincipalService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class LoginAuthConfig {
    @Bean
    fun loginAuthService(loginAuthGateway: LoginAuthGateway, findClientByPrincipalService: FindClientByPrincipalService): LoginAuthService {
        return LoginAuthUseCase(loginAuthGateway, findClientByPrincipalService)
    }
}
