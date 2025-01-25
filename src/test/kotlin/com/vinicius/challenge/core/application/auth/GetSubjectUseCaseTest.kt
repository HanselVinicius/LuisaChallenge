package com.vinicius.challenge.core.application.auth

import com.vinicius.challenge.core.application.auth.gateway.GetSubjectGateway
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class GetSubjectUseCaseTest {
    @Test
    fun shouldCallGatewayToGetSubject() {
        // arrange
        val token = "token"
        val expected = "subject"
        val gateway = mock(GetSubjectGateway::class.java)
        val getSubjectUseCase = GetSubjectUseCase(gateway)

        // act
        `when`(gateway.getSubject(token)).thenReturn(expected)
        val subject = getSubjectUseCase.getSubject(token)
        // assert
        assertEquals(expected, subject)
    }
}
