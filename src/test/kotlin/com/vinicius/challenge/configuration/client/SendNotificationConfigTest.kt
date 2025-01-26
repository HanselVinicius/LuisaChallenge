package com.vinicius.challenge.configuration.client

import com.vinicius.challenge.core.application.client.gateway.SendNotificationGateway
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock

class SendNotificationConfigTest {

    @Test
    fun testSendNotificationService() {
        // arrange
        val sendNotificationGateway = mock<SendNotificationGateway>()
        val sendNotificationConfig = SendNotificationConfig()

        // act
        val result = sendNotificationConfig.sendNotificationService(sendNotificationGateway)

        // assert
        assertNotNull(result)
    }
}
