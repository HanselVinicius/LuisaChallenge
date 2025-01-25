package com.vinicius.challenge.gateway.auth.entity

import com.vinicius.challenge.core.domain.auth.Auth

object AuthEntityMapper {
    fun toDomain(authEntity: AuthEntity): Auth {
        return Auth(
            id = authEntity.id,
            principal = authEntity.principal,
            credentials = authEntity.credentials,
            enabled = authEntity.enabled
        )
    }

    fun toEntity(auth: Auth): AuthEntity {
        return AuthEntity(
            id = auth.id,
            principal = auth.principal,
            credentials = auth.credentials,
            enabled = auth.enabled
        )
    }
}
