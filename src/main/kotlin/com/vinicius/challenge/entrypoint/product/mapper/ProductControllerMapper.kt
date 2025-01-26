package com.vinicius.challenge.entrypoint.product.mapper

import com.vinicius.challenge.core.domain.product.Product
import com.vinicius.challenge.entrypoint.product.dto.FavoriteProductDto

object ProductControllerMapper {

    fun toDomainFomInsertProductDto(productDto: FavoriteProductDto): Product {
        return Product(
            productId = productDto.id,
            title = productDto.title,
            description = productDto.description,
            price = productDto.price,
            image = productDto.image,
            enabled = true
        )
    }
}
