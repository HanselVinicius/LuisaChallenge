package com.vinicius.challenge.core.application.client.gateway

import com.vinicius.challenge.core.domain.client.Client

interface SendNotificationGateway {
    fun sendNotification(client: Client, message: String)
}
