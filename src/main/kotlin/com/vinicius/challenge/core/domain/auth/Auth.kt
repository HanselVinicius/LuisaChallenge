package com.vinicius.challenge.core.domain.auth

class Auth(
    var id: Long?,
    val principal: String,
    var credentials: String,
    var enabled: Boolean
)
