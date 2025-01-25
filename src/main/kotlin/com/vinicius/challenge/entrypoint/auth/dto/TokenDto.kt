package com.vinicius.challenge.entrypoint.auth.dto

data class TokenDto(
    val token: String,
    val clientName: String,
    val favoriteListId: Long?,
    val clientId: Long
)
