package com.vinicius.challenge.core.domain.client

import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.core.domain.product.Product
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigDecimal
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class FavoriteListTest {

    @Test
    fun shouldUpdateFieldsCorrectly() {
        // Arrange
        val client = Client(1, "test", Auth(0, "principal", "credentials", true), null, true)

        val favoriteListToEdit = FavoriteList(
            id = 1,
            name = "old Favorite",
            description = "This is a old favorite list",
            client = client,
            products = emptySet(),
            enabled = true
        )

        val favoriteList = FavoriteList(
            id = 1,
            name = "New Favorite",
            description = "This is a new favorite list",
            client = client,
            products = emptySet(),
            enabled = true
        )

        // Act
        favoriteListToEdit.editFavoriteList(favoriteList)

        // Assert
        assertEquals("New Favorite", favoriteList.name)
        assertEquals("This is a new favorite list", favoriteList.description)
    }

    @Test
    fun shouldThrowExceptionWhenAddingDuplicateProduct() {
        // Arrange
        val client = Client(1, "test", Auth(0, "principal", "credentials", true), null, true)
        val favoriteList = FavoriteList(
            id = 1,
            name = "My Favorite List",
            description = "Favorite List Description",
            client = client,
            products = mutableSetOf(),
            enabled = true
        )

        val product = Product(1L, 1, "Product 1", BigDecimal("100.0"), "Description 1", "image.jpg", true)

        // Act
        favoriteList.addFavoriteProduct(product)

        val exception = assertThrows<IllegalArgumentException> {
            favoriteList.addFavoriteProduct(product)
        }
        assertEquals("Product already in list", exception.message)
    }

    @Test
    fun shouldThrowExceptionWhenDeletingProductThatDoesNotExist() {
        // Arrange
        val client = Client(1, "test", Auth(0, "principal", "credentials", true), null, true)
        val favoriteList = FavoriteList(
            id = 1,
            name = "My Favorite List",
            description = "Favorite List Description",
            client = client,
            products = mutableSetOf(),
            enabled = true
        )

        val product = Product(1L, 1, "Product 1", BigDecimal("100.0"), "Description 1", "image.jpg", true)

        // Act & Add a product
        favoriteList.addFavoriteProduct(product)

        // Assert
        val exception = assertThrows<IllegalArgumentException> {
            favoriteList.deleteProduct(999L)
        }
        assertEquals("Product not found", exception.message)
    }

    @Test
    fun shouldDeleteAllProducts() {
        // Arrange
        val client = Client(1, "test", Auth(0, "principal", "credentials", true), null, true)
        val favoriteList = FavoriteList(
            id = 1,
            name = "My Favorite List",
            description = "Favorite List Description",
            client = client,
            products = mutableSetOf(),
            enabled = true
        )

        val product1 = Product(1L, 1, "Product 1", BigDecimal("100.0"), "Description 1", "image1.jpg", true)
        val product2 = Product(2L, 2, "Product 2", BigDecimal("150.0"), "Description 2", "image2.jpg", true)

        // Act
        favoriteList.addFavoriteProduct(product1)
        favoriteList.addFavoriteProduct(product2)

        // assert

        var enabledProducts = favoriteList.products.find { it.enabled }

        assertNotNull(enabledProducts)

        favoriteList.deleteAllProducts()
        enabledProducts = favoriteList.products.find { it.enabled }

        assertNull(enabledProducts)
    }
}
