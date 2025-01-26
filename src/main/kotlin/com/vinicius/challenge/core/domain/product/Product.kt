package com.vinicius.challenge.core.domain.product

import com.vinicius.challenge.core.domain.client.FavoriteList
import java.math.BigDecimal

class Product(
    val id: Long? = null,
    val productId: Long,
    val title: String,
    val price: BigDecimal,
    val description: String,
    val image: String,
    var enabled: Boolean,
    var favoriteList: FavoriteList? = null
) {

    override fun hashCode(): Int {
        return productId.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        return other is Product && productId == other.productId
    }

    fun deleteProduct() {
        this.enabled = false
    }
}
