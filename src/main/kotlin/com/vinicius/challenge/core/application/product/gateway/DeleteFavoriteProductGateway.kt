package com.vinicius.challenge.core.application.product.gateway

import com.vinicius.challenge.core.domain.product.Product

interface DeleteFavoriteProductGateway {
    fun deleteFavoriteProduct(product: Product)
}
