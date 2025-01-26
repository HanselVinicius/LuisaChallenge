package com.vinicius.challenge.core.domain.product.service

interface DeleteFavoriteProductService {
    fun deleteFavoriteProduct(clientId: Long, productId: Long)
}
