package com.vinicius.challenge.entrypoint.auth.mapper

import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.entrypoint.auth.dto.AuthDto
import com.vinicius.challenge.entrypoint.auth.dto.RegisterDto

object AuthControllerMapper {
    fun toDomain(authDto: AuthDto): Auth {
        return Auth(
            id = null,
            principal = authDto.principal,
            credentials = authDto.credentials,
            enabled = true
        )
    }

    fun toDomain(registerDto: RegisterDto): Auth {
        return Auth(
            id = null,
            principal = registerDto.principal,
            credentials = registerDto.credentials,
            enabled = true
        )
    }
}
