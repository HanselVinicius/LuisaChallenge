package com.vinicius.challenge.configuration.security.auth

import com.vinicius.challenge.core.application.auth.InsertAuthUseCase
import com.vinicius.challenge.core.application.auth.gateway.InsertAuthGateway
import com.vinicius.challenge.core.domain.auth.service.GetAuthByPrincipalService
import com.vinicius.challenge.core.domain.auth.service.InsertAuthService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertAuthConfig {
    @Bean
    fun insertAuthService(insertAuthGateway: InsertAuthGateway, getAuthByPrincipalService: GetAuthByPrincipalService): InsertAuthService {
        return InsertAuthUseCase(insertAuthGateway, getAuthByPrincipalService)
    }
}
