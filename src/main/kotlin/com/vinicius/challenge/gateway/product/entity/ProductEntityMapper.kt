package com.vinicius.challenge.gateway.product.entity

import com.vinicius.challenge.core.domain.product.Product
import com.vinicius.challenge.gateway.client.favorite.entity.FavoriteListEntityMapper

object ProductEntityMapper {

    fun toEntity(product: Product): ProductEntity {
        return ProductEntity(
            id = product.id,
            productId = product.productId,
            title = product.title,
            description = product.description,
            price = product.price,
            image = product.image,
            enabled = product.enabled,
            favoriteListEntity = product.favoriteList?.let { FavoriteListEntityMapper.toEntityWithoutProducts(it) }
        )
    }

    fun toDomain(productEntity: ProductEntity): Product {
        return Product(
            id = productEntity.id,
            productId = productEntity.productId,
            title = productEntity.title,
            description = productEntity.description,
            price = productEntity.price,
            image = productEntity.image,
            enabled = productEntity.enabled
        )
    }
}
