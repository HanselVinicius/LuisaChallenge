package com.vinicius.challenge.core.domain.client

import com.vinicius.challenge.core.domain.auth.Auth

class Client(
    val id: Long?,
    val name: String,
    val auth: Auth,
    val favoriteList: FavoriteList? = null,
    var enabled: Boolean
)
