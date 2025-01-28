package com.vinicius.challenge.configuration.client

import com.vinicius.challenge.core.application.client.SendNotificationUseCase
import com.vinicius.challenge.core.application.client.gateway.SendNotificationGateway
import com.vinicius.challenge.core.domain.client.service.SendNotificationService
import com.vinicius.challenge.gateway.client.SendEmailNotificationGatewayImpl
import com.vinicius.challenge.gateway.client.SendLogNotificationGatewayImpl
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.mail.javamail.JavaMailSender

@Configuration
class SendNotificationConfig {

    @Bean
    fun sendNotificationService(sendNotificationGateway: SendNotificationGateway): SendNotificationService {
        return SendNotificationUseCase(sendNotificationGateway)
    }

    @Bean
    @ConditionalOnProperty(name = ["spring.mail.enabled"], havingValue = "true")
    fun sendEmailNotificationGateway(javaMailSender: JavaMailSender): SendNotificationGateway {
        return SendEmailNotificationGatewayImpl(javaMailSender)
    }

    @Bean
    @ConditionalOnMissingBean
    fun sendLogNotificationGateway(): SendNotificationGateway {
        return SendLogNotificationGatewayImpl()
    }
}
