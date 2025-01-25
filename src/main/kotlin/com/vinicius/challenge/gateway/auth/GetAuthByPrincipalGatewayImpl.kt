package com.vinicius.challenge.gateway.auth

import com.vinicius.challenge.core.application.auth.gateway.GetAuthByPrincipalGateway
import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.gateway.auth.entity.AuthEntityMapper
import com.vinicius.challenge.gateway.auth.entity.AuthEntityRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class GetAuthByPrincipalGatewayImpl(private val authEntityRepository: AuthEntityRepository) :
    GetAuthByPrincipalGateway,
    UserDetailsService {
    override fun getAuthByPrincipal(principal: String): Auth? {
        val authEntity = authEntityRepository.findByPrincipal(principal) ?: return null
        return AuthEntityMapper.toDomain(authEntity)
    }

    override fun loadUserByUsername(principal: String?): UserDetails? {
        return authEntityRepository.findByPrincipal(principal!!)
    }
}
