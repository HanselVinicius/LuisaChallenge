package com.vinicius.challenge.gateway.client

import com.vinicius.challenge.core.application.client.gateway.SendNotificationGateway
import com.vinicius.challenge.core.domain.client.Client
import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender

class SendEmailNotificationGatewayImpl(
    private val javaMailSender: JavaMailSender
) : SendNotificationGateway {

    @Value("\${spring.mail.from}")
    private lateinit var from: String

    override fun sendNotification(client: Client, message: String) {
        val notification = SimpleMailMessage()
        notification.setTo(client.auth.principal)
        notification.from = from
        notification.subject = "Notification"
        notification.text = message

        javaMailSender.send(notification)
    }
}
