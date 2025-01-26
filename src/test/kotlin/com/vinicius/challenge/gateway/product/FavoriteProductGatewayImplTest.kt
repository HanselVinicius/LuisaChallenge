package com.vinicius.challenge.gateway.product

import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.core.domain.client.FavoriteList
import com.vinicius.challenge.core.domain.product.Product
import com.vinicius.challenge.gateway.product.entity.ProductEntityRepository
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import java.math.BigDecimal

class FavoriteProductGatewayImplTest {
    @Test
    fun shouldFavoriteProduct() {
        // arrange
        val product = Product(1L, 1, "Product", BigDecimal.TEN, "test", "image", true)
        val auth = Auth(0, "vinicius@gmail.com", "123456", true)
        val favoriteList = FavoriteList(
            id = 1,
            name = "Favorite List",
            description = "Favorite List Description",
            products = setOf(),
            enabled = true
        )
        val client = Client(1, "Vinicius", auth, favoriteList, true)
        val productEntityRepository: ProductEntityRepository = mock()
        val favoriteProductGatewayImpl = FavoriteProductGatewayImpl(productEntityRepository)
        // act
        favoriteProductGatewayImpl.favoriteProduct(product, client)
        // assert
        verify(productEntityRepository).save(any())
    }
}
