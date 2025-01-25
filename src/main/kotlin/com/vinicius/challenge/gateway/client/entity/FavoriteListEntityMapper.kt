package com.vinicius.challenge.gateway.client.entity

import com.vinicius.challenge.core.domain.client.FavoriteList
import com.vinicius.challenge.gateway.product.ProductEntityMapper

object FavoriteListEntityMapper {
    fun toDomainSimple(favoriteListEntity: FavoriteListEntity): FavoriteList {
        return FavoriteList(
            id = favoriteListEntity.id,
            name = favoriteListEntity.name,
            description = favoriteListEntity.description,
            products = favoriteListEntity.products.map { ProductEntityMapper.toDomainSimple(it) }.toSet(),
            enabled = favoriteListEntity.enabled
        )
    }

    fun toEntity(favoriteListEntity: FavoriteList): FavoriteListEntity {
        return FavoriteListEntity(
            id = favoriteListEntity.id,
            name = favoriteListEntity.name,
            description = favoriteListEntity.description,
            products = favoriteListEntity.products.map { ProductEntityMapper.toEntitySimple(it) }.toSet(),
            enabled = favoriteListEntity.enabled
        )
    }
}
