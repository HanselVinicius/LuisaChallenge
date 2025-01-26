package com.vinicius.challenge.core.application.product.gateway

import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.core.domain.product.Product

interface FavoriteProductGateway {
    fun favoriteProduct(product: Product, client: Client)
}
