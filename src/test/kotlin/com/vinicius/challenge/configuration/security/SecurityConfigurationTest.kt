package com.vinicius.challenge.configuration.security

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito.mock
import org.mockito.kotlin.any
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class SecurityConfigurationTest {

    private val securityFilter: SecurityFilter = mock()
    private val authenticationConfiguration: AuthenticationConfiguration = mock()
    private val httpSecurity: HttpSecurity = mock()
    private val securityConfiguration = SecurityConfiguration(securityFilter)

    @Test
    fun shouldCreateSecurityFilterChain() {
        // Arrange
        val securityFilterChainMock: DefaultSecurityFilterChain = mock()

        whenever(httpSecurity.cors(any())).thenReturn(httpSecurity)
        whenever(httpSecurity.csrf(any())).thenReturn(httpSecurity)
        whenever(httpSecurity.sessionManagement(any())).thenReturn(httpSecurity)
        whenever(httpSecurity.authorizeHttpRequests(any())).thenReturn(httpSecurity)
        whenever(httpSecurity.addFilterBefore(any(), any())).thenReturn(httpSecurity)
        whenever(httpSecurity.build()).thenReturn(securityFilterChainMock)

        // Act
        val securityFilterChain = securityConfiguration.securityFilterChain(httpSecurity)

        // Assert
        verify(httpSecurity).cors(any())
        verify(httpSecurity).csrf(any())
        verify(httpSecurity).sessionManagement(any())
        verify(httpSecurity).authorizeHttpRequests(any())
        verify(httpSecurity).addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter::class.java)
        verify(httpSecurity).build()

        assert(securityFilterChain == securityFilterChainMock)
    }

    @Test
    fun shouldSetSessionCreationPolicyToStateless() {
        // Arrange
        whenever(httpSecurity.cors(any())).thenReturn(httpSecurity)
        whenever(httpSecurity.csrf(any())).thenReturn(httpSecurity)
        whenever(httpSecurity.sessionManagement(any())).thenReturn(httpSecurity)
        whenever(httpSecurity.authorizeHttpRequests(any())).thenReturn(httpSecurity)
        whenever(httpSecurity.addFilterBefore(any(), any())).thenReturn(httpSecurity)
        whenever(httpSecurity.build()).thenReturn(mock())

        // Act
        securityConfiguration.securityFilterChain(httpSecurity)

        // Assert
        verify(httpSecurity).sessionManagement(any())
    }

    @Test
    fun shouldAuthorizeHttpRequestsCorrectly() {
        // Arrange
        whenever(httpSecurity.cors(any())).thenReturn(httpSecurity)
        whenever(httpSecurity.csrf(any())).thenReturn(httpSecurity)
        whenever(httpSecurity.sessionManagement(any())).thenReturn(httpSecurity)
        whenever(httpSecurity.authorizeHttpRequests(any())).thenReturn(httpSecurity)
        whenever(httpSecurity.addFilterBefore(any(), any())).thenReturn(httpSecurity)
        whenever(httpSecurity.build()).thenReturn(mock())

        // Act
        securityConfiguration.securityFilterChain(httpSecurity)

        // Assert
        verify(httpSecurity).authorizeHttpRequests(any())
    }

    @Test
    fun shouldCreatePasswordEncoder() {
        // Act
        val passwordEncoder: PasswordEncoder = securityConfiguration.passwordEncoder()

        // Assert
        assert(passwordEncoder is BCryptPasswordEncoder)
    }

    @Test
    fun shouldCreateAuthenticationManager() {
        // Arrange
        val authenticationManagerMock: AuthenticationManager = mock()
        whenever(authenticationConfiguration.authenticationManager).thenReturn(authenticationManagerMock)

        // Act
        val authenticationManager = securityConfiguration.authenticationManager(authenticationConfiguration)

        // Assert
        verify(authenticationConfiguration).authenticationManager
        assert(authenticationManager == authenticationManagerMock)
    }

    @Test
    fun shouldThrowExceptionIfSecurityFilterChainFails() {
        // Arrange
        whenever(httpSecurity.build()).thenThrow(RuntimeException("Security Filter Chain error"))

        // Act & Assert
        assertThrows<RuntimeException> {
            securityConfiguration.securityFilterChain(httpSecurity)
        }
    }
}
