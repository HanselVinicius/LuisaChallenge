package com.vinicius.challenge.core.application.client

import com.vinicius.challenge.core.application.client.gateway.SendNotificationGateway
import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.core.domain.client.Client
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class SendNotificationUseCaseTest {
    @Test
    fun shouldCallGatewayToSendNotification() {
        // arrange
        val sendNotificationGateway = mock<SendNotificationGateway>()
        val sendNotificationUseCase = SendNotificationUseCase(sendNotificationGateway)
        val principal = "test"
        val credentials = "test"
        val client = Client(1, "test", Auth(0, principal, credentials, true), null, true)

        // act
        sendNotificationUseCase.sendNotification(client, "test")

        // assert
        verify(sendNotificationGateway).sendNotification(client, "test")
    }
}
