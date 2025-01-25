package com.vinicius.challenge.gateway.auth

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.vinicius.challenge.configuration.security.SecurityProperties
import com.vinicius.challenge.core.application.auth.gateway.GetSubjectGateway
import org.springframework.stereotype.Component

@Component
class GetSubjectGatewayImpl(private val securityProperties: SecurityProperties) : GetSubjectGateway {
    override fun getSubject(token: String): String {
        val algorithm = Algorithm.HMAC256(securityProperties.secret)
        return JWT.require(algorithm)
            .withIssuer(securityProperties.issuer)
            .build()
            .verify(token.trim())
            .subject
    }
}
