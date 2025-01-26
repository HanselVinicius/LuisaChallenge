package com.vinicius.challenge.entrypoint.favorite.mapper

import com.vinicius.challenge.core.domain.client.FavoriteList
import com.vinicius.challenge.core.domain.product.Product
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class FavoriteListControllerMapperTest {

    @Test
    fun shouldMapFavoriteListToFavoriteListReturnDtoCorrectly() {
        // Arrange
        val product1 = Product(1L, 1L, "Product 1", BigDecimal(100), "Description 1", "image1.jpg", true, null)
        val product2 = Product(1L, 2L, "Product 2", BigDecimal(150), "Description 2", "image2.jpg", true, null)

        val favoriteList = FavoriteList(
            id = 1L,
            name = "My Favorite List",
            description = "A list of my favorite products",
            products = setOf(product1, product2),
            enabled = true
        )

        // Act
        val result = FavoriteListControllerMapper.fromFavoriteList(favoriteList)

        // Assert
        assertNotNull(result)
        assertEquals(favoriteList.id, result.id)
        assertEquals(favoriteList.name, result.name)
        assertEquals(favoriteList.description, result.description)
        assertEquals(2, result.products.size)

        val productReturnDto = result.products.first()
        assertEquals(product1.productId, productReturnDto.id)
        assertEquals(product1.title, productReturnDto.name)
        assertEquals(product1.description, productReturnDto.description)
        assertEquals(product1.price.toDouble(), productReturnDto.price)
        assertEquals(product1.image, productReturnDto.image)
    }

    @Test
    fun shouldMapProductToProductReturnDtoCorrectly() {
        // Arrange
        val product = Product(1L, 1L, "Product 1", BigDecimal(100), "Description 1", "image1.jpg", true, null)

        // Act
        val result = FavoriteListControllerMapper.fromProduct(product)

        // Assert
        assertNotNull(result)
        assertEquals(product.productId, result.id)
        assertEquals(product.title, result.name)
        assertEquals(product.description, result.description)
        assertEquals(product.price.toDouble(), result.price)
        assertEquals(product.image, result.image)
    }

    @Test
    fun shouldMapFavoriteListWithNoProductsCorrectly() {
        // Arrange
        val favoriteList = FavoriteList(
            id = 1L,
            name = "Empty Favorite List",
            description = "A list with no products",
            products = emptySet(),
            enabled = true
        )

        // Act
        val result = FavoriteListControllerMapper.fromFavoriteList(favoriteList)

        // Assert
        assertNotNull(result)
        assertEquals(favoriteList.id, result.id)
        assertEquals(favoriteList.name, result.name)
        assertEquals(favoriteList.description, result.description)
        assertTrue(result.products.isEmpty())
    }
}
