package com.vinicius.challenge.core.domain.auth.service

import com.vinicius.challenge.core.domain.auth.Auth

interface InsertAuthService {
    fun insertAuth(auth: Auth): Auth
}
