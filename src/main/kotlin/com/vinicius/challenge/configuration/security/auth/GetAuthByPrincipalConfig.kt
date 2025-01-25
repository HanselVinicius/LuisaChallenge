package com.vinicius.challenge.configuration.security.auth

import com.vinicius.challenge.core.application.auth.GetAuthByPrincipalUseCase
import com.vinicius.challenge.core.application.auth.gateway.GetAuthByPrincipalGateway
import com.vinicius.challenge.core.domain.auth.service.GetAuthByPrincipalService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GetAuthByPrincipalConfig {
    @Bean
    fun getAuthByPrincipalService(getAuthByPrincipalGateway: GetAuthByPrincipalGateway): GetAuthByPrincipalService {
        return GetAuthByPrincipalUseCase(getAuthByPrincipalGateway)
    }
}
