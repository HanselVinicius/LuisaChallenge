package com.vinicius.challenge.entrypoint.auth.dto

import com.vinicius.challenge.core.domain.client.FavoriteList

data class TokenDto(
    val token: String,
    val clientName: String,
    val favoriteList: FavoriteList?
)
