package com.vinicius.challenge.core.application.product

import com.vinicius.challenge.core.application.client.GetClientByIdUseCase
import com.vinicius.challenge.core.application.product.gateway.FavoriteProductGateway
import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.core.domain.client.FavoriteList
import com.vinicius.challenge.core.domain.client.service.SendNotificationService
import com.vinicius.challenge.core.domain.product.Product
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import java.math.BigDecimal

class FavoriteProductUseCaseTest {

    @Test
    fun shouldCallGatewayToFavoriteProduct() {
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
        val favoriteProductGateway = mock<FavoriteProductGateway>()
        val sendNotificationService = mock<SendNotificationService>()
        val favoriteProductUseCase = FavoriteProductUseCase(getClientByIdUseCase, favoriteProductGateway, sendNotificationService)

        // act
        favoriteProductUseCase.favoriteProduct(product, clientId)
        // assert
        verify(favoriteProductGateway).favoriteProduct(product, client)
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
        val favoriteProductGateway = mock<FavoriteProductGateway>()
        val sendNotificationService = mock<SendNotificationService>()
        val favoriteProductUseCase = FavoriteProductUseCase(getClientByIdUseCase, favoriteProductGateway, sendNotificationService)

        // act & assert
        assertThrows<IllegalArgumentException> { favoriteProductUseCase.favoriteProduct(product, clientId) }
    }

    @Test
    fun shouldReturnErrorIfAlreadyHaveFiveProducts() {
        // arrange
        val product = Product(
            productId = 1L,
            title = "Product 6",
            price = BigDecimal(100),
            description = "Description",
            image = "image",
            enabled = true
        )
        val setOfProduct = setOf(
            Product(
                productId = 1L,
                title = "Product 1",
                price = BigDecimal(100),
                description = "Description",
                image = "image",
                enabled = true
            ),
            Product(
                productId = 2L,
                title = "Product 2",
                price = BigDecimal(100),
                description = "Description",
                image = "image",
                enabled = true
            ),
            Product(
                productId = 3L,
                title = "Product 3",
                price = BigDecimal(100),
                description = "Description",
                image = "image",
                enabled = true
            ),
            Product(
                productId = 4L,
                title = "Product 4",
                price = BigDecimal(100),
                description = "Description",
                image = "image",
                enabled = true
            ),
            Product(
                productId = 5L,
                title = "Product 5",
                price = BigDecimal(100),
                description = "Description",
                image = "image",
                enabled = true
            )
        )
        val favoriteList = FavoriteList(
            id = 1L,
            products = setOfProduct,
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
        val favoriteProductGateway = mock<FavoriteProductGateway>()
        val sendNotificationService = mock<SendNotificationService>()
        val favoriteProductUseCase = FavoriteProductUseCase(getClientByIdUseCase, favoriteProductGateway, sendNotificationService)

        // act & assert
        assertThrows<IllegalArgumentException> { favoriteProductUseCase.favoriteProduct(product, clientId) }
    }
}
