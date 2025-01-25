package com.vinicius.challenge.core.domain.auth.service

import com.vinicius.challenge.core.domain.auth.dto.LoginDto

interface LoginAuthService {
    fun login(principal: String, credentials: String): LoginDto
}
