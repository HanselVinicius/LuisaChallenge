package com.vinicius.challenge.gateway.auth

import com.vinicius.challenge.core.application.auth.gateway.InsertAuthGateway
import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.gateway.auth.entity.AuthEntityMapper
import com.vinicius.challenge.gateway.auth.entity.AuthEntityRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
class InsertAuthGatewayImpl(private val authEntityRepository: AuthEntityRepository) : InsertAuthGateway {
    override fun insertAuth(auth: Auth): Auth {
        auth.credentials = BCryptPasswordEncoder().encode(auth.credentials)
        val authEntity = AuthEntityMapper.toEntity(auth)
        return AuthEntityMapper.toDomain(this.authEntityRepository.save(authEntity))
    }
}
