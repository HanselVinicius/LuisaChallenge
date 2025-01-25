package com.vinicius.challenge.gateway.auth

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.vinicius.challenge.configuration.security.SecurityProperties
import com.vinicius.challenge.gateway.auth.entity.AuthEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Component
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

@Component
class AuthManagerGateway(private val manager: AuthenticationManager, private val securityProperties: SecurityProperties) {
    fun authenticate(username: String, password: String): String {
        val token = manager.authenticate(UsernamePasswordAuthenticationToken(username, password))
        return generateToken(token.principal as AuthEntity)
    }

    private fun generateToken(user: AuthEntity): String {
        val algorithm = Algorithm.HMAC256(securityProperties.secret)
        return JWT.create()
            .withIssuer(securityProperties.issuer)
            .withSubject(user.principal)
            .withExpiresAt(dataExpiracao())
            .sign(algorithm)
    }

    private fun dataExpiracao(): Instant {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"))
    }
}
