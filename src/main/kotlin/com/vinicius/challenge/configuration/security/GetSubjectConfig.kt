package com.vinicius.challenge.configuration.security

import com.vinicius.challenge.core.application.auth.GetSubjectUseCase
import com.vinicius.challenge.core.application.auth.gateway.GetSubjectGateway
import com.vinicius.challenge.core.domain.auth.service.GetSubjectService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GetSubjectConfig {

    @Bean
    fun getSubjectService(getSubjectGateway: GetSubjectGateway): GetSubjectService {
        return GetSubjectUseCase(getSubjectGateway)
    }
}
