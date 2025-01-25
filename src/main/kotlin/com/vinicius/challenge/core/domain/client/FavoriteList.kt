package com.vinicius.challenge.core.domain.client

import com.vinicius.challenge.core.domain.product.Product

class FavoriteList(
    val id: Long?,
    var name: String,
    var description: String,
    val products: Set<Product>,
    var client: Client? = null,
    var enabled: Boolean
) {
    fun editFavoriteList(favoriteList: FavoriteList) {
        this.name = favoriteList.name
        this.description = favoriteList.description
        this.client = favoriteList.client
    }

    fun deleteFavoriteList() {
        this.enabled = false
    }
}
