package com.vinicius.challenge.core.domain.client

import com.vinicius.challenge.core.domain.product.Product

class FavoriteList(
    val id: Long?,
    val name: String,
    val description: String,
    val products: Set<Product>,
    val client: Client? = null,
    val enabled: Boolean
)
