package com.vinicius.challenge.gateway.client

import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.core.domain.client.Client
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class SendLogNotificationGatewayImplTest {

    @Test
    fun shouldPrintOnTerminalNotification() {
        // Arrange
        val sendNotificationGateway = SendLogNotificationGatewayImpl()
        val outputStreamCaptor = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStreamCaptor))
        val client = Client(1, "test", Auth(0, "test@example.com", "credentials", true), null, true)
        val message = "This is a test notification"

        sendNotificationGateway.sendNotification(client, message)

        val output = outputStreamCaptor.toString().trim()
        assertTrue(output.contains("Sending notification to test@example.com: This is a test notification"))
    }
}
