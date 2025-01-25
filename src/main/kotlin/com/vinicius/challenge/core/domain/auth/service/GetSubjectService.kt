package com.vinicius.challenge.core.domain.auth.service

interface GetSubjectService {
    fun getSubject(token: String): String
}
