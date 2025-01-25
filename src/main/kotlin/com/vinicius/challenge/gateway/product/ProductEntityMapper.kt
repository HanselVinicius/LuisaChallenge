package com.vinicius.challenge.gateway.product

import com.vinicius.challenge.core.domain.product.Product
import com.vinicius.challenge.gateway.client.favorite.entity.FavoriteListEntityMapper

object ProductEntityMapper {

    fun toEntitySimple(product: Product): ProductEntity {
        return ProductEntity(
            id = product.id,
            title = product.title,
            description = product.description,
            price = product.price,
            image = product.image,
            enabled = product.enabled,
            favoriteListEntity = product.favoriteList?.let { FavoriteListEntityMapper.toEntitySimple(it) }
        )
    }

    fun toDomainSimple(productEntity: ProductEntity): Product {
        return Product(
            id = productEntity.id,
            title = productEntity.title,
            description = productEntity.description,
            price = productEntity.price,
            image = productEntity.image,
            enabled = productEntity.enabled
        )
    }
}
