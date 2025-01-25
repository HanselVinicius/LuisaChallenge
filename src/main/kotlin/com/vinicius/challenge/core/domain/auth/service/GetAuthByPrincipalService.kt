package com.vinicius.challenge.core.domain.auth.service

import com.vinicius.challenge.core.domain.auth.Auth

interface GetAuthByPrincipalService {
    fun getAuthByPrincipal(principal: String): Auth?
}
