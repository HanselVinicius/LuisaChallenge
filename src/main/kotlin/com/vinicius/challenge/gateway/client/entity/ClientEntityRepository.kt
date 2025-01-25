package com.vinicius.challenge.gateway.client.entity

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientEntityRepository : JpaRepository<ClientEntity, Long> {
    fun findByAuthPrincipal(principal: String): ClientEntity?
}
