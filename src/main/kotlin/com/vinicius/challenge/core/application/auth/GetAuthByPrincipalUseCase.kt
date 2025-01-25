package com.vinicius.challenge.core.application.auth

import com.vinicius.challenge.core.application.auth.gateway.GetAuthByPrincipalGateway
import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.core.domain.auth.service.GetAuthByPrincipalService

class GetAuthByPrincipalUseCase(private val getAuthByPrincipalGateway: GetAuthByPrincipalGateway) : GetAuthByPrincipalService {
    override fun getAuthByPrincipal(principal: String): Auth? {
        return getAuthByPrincipalGateway.getAuthByPrincipal(principal)
    }
}
