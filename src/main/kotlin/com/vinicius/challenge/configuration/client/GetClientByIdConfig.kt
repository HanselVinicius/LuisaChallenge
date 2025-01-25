package com.vinicius.challenge.configuration.client

import com.vinicius.challenge.core.application.client.GetClientByIdUseCase
import com.vinicius.challenge.core.application.client.gateway.GetClientByIdGateway
import com.vinicius.challenge.core.domain.client.service.GetClientByIdService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GetClientByIdConfig {

    @Bean
    fun getClientByIdService(getClientByIdGateway: GetClientByIdGateway): GetClientByIdService {
        return GetClientByIdUseCase(getClientByIdGateway)
    }
}
