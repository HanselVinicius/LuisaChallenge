package com.vinicius.challenge.gateway.client

import com.vinicius.challenge.core.application.client.gateway.SendNotificationGateway
import com.vinicius.challenge.core.domain.client.Client

class SendLogNotificationGatewayImpl() : SendNotificationGateway {
    override fun sendNotification(client: Client, message: String) {
        println("Sending notification to ${client.auth.principal}: $message")
    }
}
