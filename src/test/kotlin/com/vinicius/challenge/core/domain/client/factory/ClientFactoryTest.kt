package com.vinicius.challenge.core.domain.client.factory

import com.vinicius.challenge.core.domain.auth.Auth
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import kotlin.test.Test

class ClientFactoryTest {
    @Test
    fun shouldCreateClient() {
        // arrange
        val auth = Auth(1L, "username", "password", true)
        val name = "name"

        // act
        val client = ClientFactory.createClient(auth, name)

        // assert
        assertNotNull(client)
        assertEquals(name, client.name)
        assertEquals(auth, client.auth)
        assertTrue(client.enabled)
    }
}
