package com.vinicius.challenge.configuration.security

import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.core.domain.auth.service.GetAuthByPrincipalService
import com.vinicius.challenge.core.domain.auth.service.GetSubjectService
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import java.lang.reflect.Method

class SecurityFilterTest {

    @Test
    fun shouldRetrieveTokenFromRequestHeader() {
        // Arrange
        val getSubjectService = mock<GetSubjectService>()
        val getAuthByPrincipalService = mock<GetAuthByPrincipalService>()
        val securityFilter = SecurityFilter(getSubjectService, getAuthByPrincipalService)
        val request = mock<HttpServletRequest> {
            on { getHeader("Authorization") } doReturn "Bearer test_token"
        }

        // Act
        val token = securityFilter.retrieveToken(request)

        // Assert
        assertEquals("test_token", token)
    }

    @Test
    fun shouldCallAuthServiceToInsertClient() {
        // Arrange
        val response = mock<HttpServletResponse>()
        val filterChain = mock<FilterChain>()
        val token = "test_token"
        val request = mock<HttpServletRequest> {
            on { getHeader("Authorization") } doReturn "Bearer $token"
        }
        val principal = "test_principal"
        val auth = mock<Auth> {
            on { credentials } doReturn "test_credentials"
        }
        val getSubjectService = mock<GetSubjectService> {
            on { getSubject(token) } doReturn principal
        }
        val getAuthByPrincipalService = mock<GetAuthByPrincipalService> {
            on { getAuthByPrincipal(principal) } doReturn auth
        }
        val securityFilter = SecurityFilter(getSubjectService, getAuthByPrincipalService)

        // Act
        val method: Method = SecurityFilter::class.java.getDeclaredMethod("doFilterInternal", HttpServletRequest::class.java, HttpServletResponse::class.java, FilterChain::class.java)
        method.isAccessible = true
        method.invoke(securityFilter, request, response, filterChain)
        // Assert
        verify(getSubjectService).getSubject(token)
        verify(getAuthByPrincipalService).getAuthByPrincipal(principal)
        val authentication = SecurityContextHolder.getContext().authentication as UsernamePasswordAuthenticationToken
        assertEquals("test_credentials", authentication.credentials)
        assertEquals("ROLE_USER", authentication.authorities.first().authority)
        verify(filterChain).doFilter(request, response)
    }

    @Test
    fun shouldNotProcessFilterIfNoTokenPresent() {
        // Arrange
        val getSubjectService = mock<GetSubjectService>()
        val getAuthByPrincipalService = mock<GetAuthByPrincipalService>()
        val securityFilter = SecurityFilter(getSubjectService, getAuthByPrincipalService)

        val request = mock<HttpServletRequest> {
            on { getHeader("Authorization") } doReturn null
        }
        val response = mock<HttpServletResponse>()
        val filterChain = mock<FilterChain>()

        // Act
        val method: Method = SecurityFilter::class.java.getDeclaredMethod("doFilterInternal", HttpServletRequest::class.java, HttpServletResponse::class.java, FilterChain::class.java)
        method.isAccessible = true
        method.invoke(securityFilter, request, response, filterChain)
        // Assert
        verify(filterChain).doFilter(request, response)
        assertNull(SecurityContextHolder.getContext().authentication)
    }
}
