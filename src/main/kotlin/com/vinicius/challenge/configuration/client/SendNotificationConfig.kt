package com.vinicius.challenge.configuration.client

import com.vinicius.challenge.core.application.client.SendNotificationUseCase
import com.vinicius.challenge.core.application.client.gateway.SendNotificationGateway
import com.vinicius.challenge.core.domain.client.service.SendNotificationService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SendNotificationConfig {

    @Bean
    fun sendNotificationService(sendNotificationGateway: SendNotificationGateway): SendNotificationService {
        return SendNotificationUseCase(sendNotificationGateway)
    }
}
