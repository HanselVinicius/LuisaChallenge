package com.vinicius.challenge.gateway.auth.entity

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthEntityRepository : JpaRepository<AuthEntity, Long> {
    fun findByPrincipal(principal: String): AuthEntity?
}
