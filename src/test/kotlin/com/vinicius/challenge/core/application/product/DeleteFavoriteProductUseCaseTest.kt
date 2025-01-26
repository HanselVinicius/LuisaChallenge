package com.vinicius.challenge.core.application.product

import com.vinicius.challenge.core.application.client.GetClientByIdUseCase
import com.vinicius.challenge.core.application.product.gateway.DeleteFavoriteProductGateway
import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.core.domain.client.FavoriteList
import com.vinicius.challenge.core.domain.product.Product
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import java.math.BigDecimal

class DeleteFavoriteProductUseCaseTest {
    @Test
    fun shouldCallGatewayToDeleteProduct() {
        // arrange
        val product = Product(
            productId = 1L,
            title = "Product 1",
            price = BigDecimal(100),
            description = "Description",
            image = "image",
            enabled = true
        )
        val favoriteList = FavoriteList(
            id = 1L,
            products = setOf(product),
            client = null,
            enabled = true,
            name = "Favorite List",
            description = "Description"
        )
        val clientId = 1L
        val client = Client(1, "test", Auth(0, "principal", "credentials", true), favoriteList, true)
        val getClientByIdUseCase = mock<GetClientByIdUseCase> {
            on { getClientById(clientId) } doReturn client
        }
        val deleteFavoriteProductGateway = mock<DeleteFavoriteProductGateway>()
        val deleteFavoriteProductUseCase = DeleteFavoriteProductUseCase(getClientByIdUseCase, deleteFavoriteProductGateway)

        // act
        deleteFavoriteProductUseCase.deleteFavoriteProduct(clientId, product.productId)

        // assert
        verify(deleteFavoriteProductGateway).deleteFavoriteProduct(product)
        assertFalse(product.enabled)
    }

    @Test
    fun shouldReturnErrorIfClientDoesNotHaveAFavoriteList() {
        // arrange
        val product = Product(
            productId = 1L,
            title = "Product 1",
            price = BigDecimal(100),
            description = "Description",
            image = "image",
            enabled = true
        )
        val clientId = 1L
        val client = Client(1, "test", Auth(0, "principal", "credentials", true), null, true)

        val getClientByIdUseCase = mock<GetClientByIdUseCase> {
            on { getClientById(clientId) } doReturn client
        }
        val deleteFavoriteProductGateway = mock<DeleteFavoriteProductGateway>()
        val deleteFavoriteProductUseCase = DeleteFavoriteProductUseCase(getClientByIdUseCase, deleteFavoriteProductGateway)
        // act and assert
        assertThrows(IllegalArgumentException::class.java) {
            deleteFavoriteProductUseCase.deleteFavoriteProduct(clientId, product.productId)
        }
    }

    @Test
    fun shouldThrowErrorIfFavoriteListDoesNotContainProduct() {
        // arrange
        val product = Product(
            productId = 1L,
            title = "Product 1",
            price = BigDecimal(100),
            description = "Description",
            image = "image",
            enabled = true
        )
        val favoriteList = FavoriteList(
            id = 1L,
            products = emptySet(),
            client = null,
            enabled = true,
            name = "Favorite List",
            description = "Description"
        )
        val clientId = 1L
        val client = Client(1, "test", Auth(0, "principal", "credentials", true), favoriteList, true)
        val getClientByIdUseCase = mock<GetClientByIdUseCase> {
            on { getClientById(clientId) } doReturn client
        }
        val deleteFavoriteProductGateway = mock<DeleteFavoriteProductGateway>()
        val deleteFavoriteProductUseCase = DeleteFavoriteProductUseCase(getClientByIdUseCase, deleteFavoriteProductGateway)

        // act
        assertThrows(IllegalArgumentException::class.java) {
            deleteFavoriteProductUseCase.deleteFavoriteProduct(clientId, product.productId)
        }
    }
}
