package com.vinicius.challenge.core.application.client

import com.vinicius.challenge.core.application.client.gateway.SendNotificationGateway
import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.core.domain.client.service.SendNotificationService

class SendNotificationUseCase(
    private val sendNotificationGateway: SendNotificationGateway
) : SendNotificationService {
    override fun sendNotification(client: Client, message: String) {
        sendNotificationGateway.sendNotification(client, message)
    }
}
