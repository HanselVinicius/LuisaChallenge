package com.vinicius.challenge.configuration.client

import com.vinicius.challenge.core.application.client.InsertClientUseCase
import com.vinicius.challenge.core.application.client.gateway.InsertClientGateway
import com.vinicius.challenge.core.domain.client.service.InsertClientService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertClientConfig {

    @Bean
    fun insertClientService(insertClientGateway: InsertClientGateway): InsertClientService {
        return InsertClientUseCase(insertClientGateway)
    }
}
