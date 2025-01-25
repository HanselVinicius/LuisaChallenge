package com.vinicius.challenge.core.application.auth.gateway

interface GetSubjectGateway {
    fun getSubject(token: String): String
}
