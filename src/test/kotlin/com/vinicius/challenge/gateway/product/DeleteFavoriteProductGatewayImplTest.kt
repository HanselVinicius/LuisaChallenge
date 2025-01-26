package com.vinicius.challenge.gateway.product

import com.vinicius.challenge.core.domain.product.Product
import com.vinicius.challenge.gateway.product.entity.ProductEntityRepository
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import java.math.BigDecimal

class DeleteFavoriteProductGatewayImplTest {

    @Test
    fun shouldDeleteProduct() {
        // arrange
        val product = Product(1L, 1, "Product", BigDecimal.TEN, "test", "image", true)
        val productEntityRepository: ProductEntityRepository = mock()
        val deleteFavoriteProductGatewayImpl = DeleteFavoriteProductGatewayImpl(productEntityRepository)
        // act
        deleteFavoriteProductGatewayImpl.deleteFavoriteProduct(product)
        // assert
        verify(productEntityRepository).save(any())
    }
}
