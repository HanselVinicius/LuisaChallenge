package com.vinicius.challenge.core.application.auth.gateway

import com.vinicius.challenge.core.domain.auth.Auth

interface InsertAuthGateway {
    fun insertAuth(auth: Auth): Auth
}
