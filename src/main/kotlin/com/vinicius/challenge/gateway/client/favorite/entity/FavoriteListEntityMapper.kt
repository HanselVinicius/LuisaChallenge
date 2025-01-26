package com.vinicius.challenge.gateway.client.favorite.entity

import com.vinicius.challenge.core.domain.client.FavoriteList
import com.vinicius.challenge.gateway.product.entity.ProductEntityMapper

object FavoriteListEntityMapper {
    fun toDomainSimple(favoriteListEntity: FavoriteListEntity): FavoriteList {
        return FavoriteList(
            id = favoriteListEntity.id,
            name = favoriteListEntity.name,
            description = favoriteListEntity.description,
            products = favoriteListEntity.products.map { ProductEntityMapper.toDomain(it) }.toSet(),
            enabled = favoriteListEntity.enabled
        )
    }

    fun toEntitySimple(favoriteListEntity: FavoriteList): FavoriteListEntity {
        return FavoriteListEntity(
            id = favoriteListEntity.id,
            name = favoriteListEntity.name,
            description = favoriteListEntity.description,
            products = favoriteListEntity.products.map { ProductEntityMapper.toEntity(it) }.toSet(),
            enabled = favoriteListEntity.enabled
        )
    }

    fun toEntityWithoutProducts(favoriteListEntity: FavoriteList): FavoriteListEntity {
        return FavoriteListEntity(
            id = favoriteListEntity.id,
            name = favoriteListEntity.name,
            description = favoriteListEntity.description,
            enabled = favoriteListEntity.enabled
        )
    }
}
