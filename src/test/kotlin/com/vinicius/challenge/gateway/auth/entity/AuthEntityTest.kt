package com.vinicius.challenge.gateway.auth.entity

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.security.core.authority.SimpleGrantedAuthority

class AuthEntityTest {

    @Test
    fun shouldCreateAuthEntityInstance() {
        // Arrange
        val authEntity = AuthEntity(
            id = 1L,
            principal = "user@example.com",
            credentials = "password123",
            enabled = true
        )

        // Act & Assert
        assertNotNull(authEntity)
        assertEquals(1L, authEntity.id)
        assertEquals("user@example.com", authEntity.principal)
        assertEquals("password123", authEntity.credentials)
        assertTrue(authEntity.enabled)
    }

    @Test
    fun shouldReturnAuthorities() {
        // Arrange
        val authEntity = AuthEntity(
            id = 1L,
            principal = "user@example.com",
            credentials = "password123",
            enabled = true
        )

        // Act
        val authorities = authEntity.authorities

        // Assert
        assertNotNull(authorities)
        assertEquals(1, authorities.size)
        assertTrue(authorities.contains(SimpleGrantedAuthority("ROLE_USER")))
    }

    @Test
    fun shouldReturnPassword() {
        // Arrange
        val authEntity = AuthEntity(
            id = 1L,
            principal = "user@example.com",
            credentials = "password123",
            enabled = true
        )

        // Act
        val password = authEntity.password

        // Assert
        assertEquals("password123", password)
    }

    @Test
    fun shouldReturnUsername() {
        // Arrange
        val authEntity = AuthEntity(
            id = 1L,
            principal = "user@example.com",
            credentials = "password123",
            enabled = true
        )

        // Act
        val username = authEntity.username

        // Assert
        assertEquals("user@example.com", username)
    }

    @Test
    fun shouldReturnIsEnabled() {
        // Arrange
        val authEntity = AuthEntity(
            id = 1L,
            principal = "user@example.com",
            credentials = "password123",
            enabled = true
        )

        // Act
        val isEnabled = authEntity.isEnabled

        // Assert
        assertTrue(isEnabled)
    }

    @Test
    fun shouldReturnIsNotEnabled() {
        // Arrange
        val authEntity = AuthEntity(
            id = 1L,
            principal = "user@example.com",
            credentials = "password123",
            enabled = false
        )

        // Act
        val isEnabled = authEntity.isEnabled

        // Assert
        assertFalse(isEnabled)
    }
}
