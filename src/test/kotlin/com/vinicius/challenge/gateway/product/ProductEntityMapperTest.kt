package com.vinicius.challenge.gateway.product

import com.vinicius.challenge.core.domain.product.Product
import com.vinicius.challenge.gateway.product.entity.ProductEntity
import com.vinicius.challenge.gateway.product.entity.ProductEntityMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class ProductEntityMapperTest {

    @Test
    fun shouldMapToEntity() {
        // arrange
        val product = Product(1L, 1, "title", BigDecimal.TEN, "description", "image", true)
        // act
        val productEntity = ProductEntityMapper.toEntity(product)
        // assert
        assertEquals(product.productId, productEntity.productId)
        assertEquals(product.title, productEntity.title)
        assertEquals(product.description, productEntity.description)
    }

    @Test
    fun shouldMapToDomain() {
        // arrange
        val productEntity = ProductEntity(1, 1, "title", BigDecimal.TEN, "description", "image", null, true)
        // act
        val product = ProductEntityMapper.toDomain(productEntity)
        // assert
        assertEquals(productEntity.productId, product.productId)
        assertEquals(productEntity.title, product.title)
        assertEquals(productEntity.description, product.description)
    }
}
