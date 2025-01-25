package com.vinicius.challenge.core.domain.client.service

import com.vinicius.challenge.core.domain.client.Client

interface SendNotificationService {
    fun sendNotification(client: Client, message: String)
}
