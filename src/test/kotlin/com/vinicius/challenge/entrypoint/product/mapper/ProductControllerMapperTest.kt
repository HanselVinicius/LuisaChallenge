package com.vinicius.challenge.entrypoint.product.mapper

import com.vinicius.challenge.entrypoint.product.dto.FavoriteProductDto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class ProductControllerMapperTest {

    @Test
    fun shouldReturnProductDomainWithFavoriteProductDto() {
        // arrange
        val productDto = FavoriteProductDto(
            id = 1L,
            title = "Product Title",
            description = "Product Description",
            price = BigDecimal.ZERO,
            image = "https://example.com/product-image.jpg",
            clientId = 1L
        )

        // act
        val product = ProductControllerMapper.toDomainFomInsertProductDto(productDto)

        // assert
        assertEquals(productDto.id, product.productId)
        assertEquals(productDto.title, product.title)
        assertEquals(productDto.description, product.description)
        assertEquals(productDto.price, product.price)
        assertEquals(productDto.image, product.image)
        assertTrue(product.enabled)
    }
}
