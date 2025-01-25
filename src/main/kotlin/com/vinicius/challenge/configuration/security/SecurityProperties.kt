package com.vinicius.challenge.configuration.security

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class SecurityProperties {
    @Value("\${security.jwt.secret}")
    lateinit var secret: String

    @Value("\${security.token.issuer}")
    lateinit var issuer: String
}
