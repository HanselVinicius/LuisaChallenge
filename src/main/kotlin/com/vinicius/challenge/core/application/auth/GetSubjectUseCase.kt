package com.vinicius.challenge.core.application.auth

import com.vinicius.challenge.core.application.auth.gateway.GetSubjectGateway
import com.vinicius.challenge.core.domain.auth.service.GetSubjectService

class GetSubjectUseCase(private val getSubjectGateway: GetSubjectGateway) : GetSubjectService {
    override fun getSubject(token: String): String {
        return getSubjectGateway.getSubject(token)
    }
}
