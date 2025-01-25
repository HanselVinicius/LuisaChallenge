package com.vinicius.challenge.configuration.client

import com.vinicius.challenge.core.application.client.FindClientByPrincipalUseCase
import com.vinicius.challenge.core.application.client.gateway.FindClientByPrincipalGateway
import com.vinicius.challenge.core.domain.client.service.FindClientByPrincipalService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FindClientByPrincipalConfig {

    @Bean
    fun findClientByPrincipalService(findClientByPrincipalGateway: FindClientByPrincipalGateway): FindClientByPrincipalService {
        return FindClientByPrincipalUseCase(findClientByPrincipalGateway)
    }
}
