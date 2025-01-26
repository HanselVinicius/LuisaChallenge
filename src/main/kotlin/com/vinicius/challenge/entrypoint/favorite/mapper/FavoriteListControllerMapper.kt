package com.vinicius.challenge.entrypoint.favorite.mapper

import com.vinicius.challenge.core.domain.client.FavoriteList
import com.vinicius.challenge.core.domain.product.Product
import com.vinicius.challenge.entrypoint.favorite.dto.FavoriteListReturnDto
import com.vinicius.challenge.entrypoint.favorite.dto.ProductReturnDto

object FavoriteListControllerMapper {
    fun fromFavoriteList(favoriteList: FavoriteList): FavoriteListReturnDto {
        return FavoriteListReturnDto(
            id = favoriteList.id!!,
            name = favoriteList.name,
            description = favoriteList.description,
            products = favoriteList.products.map { fromProduct(it) }.toSet()
        )
    }

    fun fromProduct(product: Product): ProductReturnDto {
        return ProductReturnDto(
            id = product.productId,
            name = product.title,
            description = product.description,
            price = product.price.toDouble(),
            image = product.image
        )
    }
}
