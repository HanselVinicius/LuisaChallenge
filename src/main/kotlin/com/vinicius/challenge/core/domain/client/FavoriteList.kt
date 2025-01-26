package com.vinicius.challenge.core.domain.client

import com.vinicius.challenge.core.domain.product.Product

class FavoriteList(
    val id: Long?,
    var name: String,
    var description: String,
    var products: Set<Product>,
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

    fun addFavoriteProduct(product: Product) {
        if (this.products.size >= 5) {
            throw IllegalArgumentException("List Already have five products")
        }
        if (this.products.contains(product)) {
            throw IllegalArgumentException("Product already in list")
        }
        product.favoriteList = this
        this.products = this.products.plus(product)
    }

    fun deleteProduct(productId: Long): Product {
        val product = this.products.find { it.productId == productId }
        if (product == null) {
            throw IllegalArgumentException("Product not found")
        }
        product.deleteProduct()
        product.favoriteList = this
        return product
    }

    fun deleteAllProducts() {
        this.products.forEach { it.deleteProduct() }
    }
}
