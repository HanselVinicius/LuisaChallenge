package com.vinicius.challenge.gateway.product

import com.vinicius.challenge.core.domain.product.Product
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class ProductEntityMapperTest {

    @Test
    fun shouldMapToEntitySimple() {
        // arrange
        val product = Product(1, "title", BigDecimal.TEN, "description", "image", true)
        // act
        val productEntity = ProductEntityMapper.toEntitySimple(product)
        // assert
        assertEquals(product.id, productEntity.id)
        assertEquals(product.title, productEntity.title)
        assertEquals(product.description, productEntity.description)
    }

    @Test
    fun shouldMapToDomainSimple() {
        // arrange
        val productEntity = ProductEntity(1, "title", BigDecimal.TEN, "description", "image", null, true)
        // act
        val product = ProductEntityMapper.toDomainSimple(productEntity)
        // assert
        assertEquals(productEntity.id, product.id)
        assertEquals(productEntity.title, product.title)
        assertEquals(productEntity.description, product.description)
    }
}
