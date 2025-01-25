package com.vinicius.challenge.gateway.client.favorite.entity

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FavoriteListEntityRepository : JpaRepository<FavoriteListEntity, Long> {
    fun findFavoriteListEntityByClientId(client: Long): FavoriteListEntity?
}
