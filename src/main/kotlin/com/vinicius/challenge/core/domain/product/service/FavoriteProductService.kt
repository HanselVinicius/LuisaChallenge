package com.vinicius.challenge.core.domain.product.service

import com.vinicius.challenge.core.domain.product.Product

interface FavoriteProductService {
    fun favoriteProduct(product: Product, clientId: Long)
}
