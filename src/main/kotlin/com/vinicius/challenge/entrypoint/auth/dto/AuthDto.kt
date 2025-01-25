package com.vinicius.challenge.entrypoint.auth.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class AuthDto(
    @field:Email
    val principal: String,
    @field:NotBlank
    val credentials: String
)
