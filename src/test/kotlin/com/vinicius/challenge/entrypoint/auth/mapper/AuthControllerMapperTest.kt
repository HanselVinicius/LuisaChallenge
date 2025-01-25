package com.vinicius.challenge.entrypoint.auth.mapper

import com.vinicius.challenge.entrypoint.auth.dto.AuthDto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AuthControllerMapperTest {

    @Test
    fun shouldReturnAuthDomainWithAuthDto() {
        // arrange
        val principal = "principal"
        val credentials = "credentials"
        val authDto = AuthDto(principal, credentials)
        // act
        val auth = AuthControllerMapper.toDomain(authDto)
        // assert
        assertEquals(authDto.principal, auth.principal)
        assertEquals(authDto.credentials, auth.credentials)
    }
}
