package com.vinicius.challenge.core.application.auth

import com.vinicius.challenge.core.application.auth.gateway.InsertAuthGateway
import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.core.domain.auth.service.GetAuthByPrincipalService
import com.vinicius.challenge.core.domain.auth.service.InsertAuthService

class InsertAuthUseCase(
    private val insertAuthGateway: InsertAuthGateway,
    private val getAuthByPrincipalService: GetAuthByPrincipalService
) : InsertAuthService {
    override fun insertAuth(auth: Auth): Auth {
        if (this.getAuthByPrincipalService.getAuthByPrincipal(auth.principal) != null) {
            throw SecurityException("User already exists")
        }
        return this.insertAuthGateway.insertAuth(auth)
    }
}
