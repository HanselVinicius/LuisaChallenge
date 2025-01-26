package com.vinicius.challenge.entrypoint.product

import com.vinicius.challenge.core.domain.product.service.DeleteFavoriteProductService
import com.vinicius.challenge.core.domain.product.service.FavoriteProductService
import com.vinicius.challenge.entrypoint.product.dto.FavoriteProductDto
import com.vinicius.challenge.entrypoint.product.mapper.ProductControllerMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.math.BigDecimal

class ProductControllerTest {

    @Test
    fun shouldCallServiceToFavoriteProductAndReturn200Ok() {
        // Arrange
        val favoriteProductDto = FavoriteProductDto(
            id = 1L,
            title = "Product Title",
            description = "Product Description",
            price = BigDecimal.TEN,
            image = "https://example.com/product-image.jpg",
            clientId = 1L
        )
        val product = ProductControllerMapper.toDomainFomInsertProductDto(favoriteProductDto)
        val favoriteProductService = mock<FavoriteProductService>()

        val deleteFavoriteProductService = mock<DeleteFavoriteProductService>()
        val productController = ProductController(favoriteProductService, deleteFavoriteProductService)

        // Act
        val response: ResponseEntity<Unit> = productController.favoriteProduct(favoriteProductDto)

        // Assert
        verify(favoriteProductService).favoriteProduct(product, favoriteProductDto.clientId)
        assertEquals(HttpStatus.OK, response.statusCode)
    }

    @Test
    fun shouldCallServiceToDeleteFavoriteProductAndReturn204NoContent() {
        // Arrange
        val clientId = 1L
        val productId = 1L

        val favoriteProductService = mock<FavoriteProductService>()
        val deleteFavoriteProductService = mock<DeleteFavoriteProductService>()

        val productController = ProductController(favoriteProductService, deleteFavoriteProductService)

        // Act
        val response: ResponseEntity<Unit> = productController.deleteFavoriteProduct(clientId, productId)

        // Assert
        verify(deleteFavoriteProductService).deleteFavoriteProduct(clientId, productId)
        assertEquals(HttpStatus.NO_CONTENT, response.statusCode)
    }
}
