package com.vinicius.challenge.gateway.client

import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.core.domain.client.Client
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender

class SendEmailNotificationGatewayImplTest {

    @Test
    fun shouldSendNotification() {
        // arrange
        val principal = "test@gmail.com"
        val credentials = "123456"
        val client = Client(1, "test", Auth(0, principal, credentials, true), null, true)
        val javaMailSender = mock<JavaMailSender>()
        val gateway = SendEmailNotificationGatewayImpl(javaMailSender)

        SendEmailNotificationGatewayImpl::class.java.getDeclaredField("FROM").apply {
            isAccessible = true
            set(null, "test@domain.com")
        }
        // act
        gateway.sendNotification(client, "test")

        // assert
        verify(javaMailSender).send(any<SimpleMailMessage>())
    }
}
