package com.vinicius.challenge.gateway.client.favorite

import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.core.domain.client.FavoriteList
import com.vinicius.challenge.core.domain.product.Product
import com.vinicius.challenge.gateway.client.favorite.entity.FavoriteListEntity
import com.vinicius.challenge.gateway.client.favorite.entity.FavoriteListEntityRepository
import com.vinicius.challenge.gateway.product.entity.ProductEntityRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.kotlin.argumentCaptor
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import java.math.BigDecimal
import kotlin.test.assertNotNull

class DeleteFavoriteListGatewayImplTest {

    @Test
    fun shouldDeleteFavoriteList() {
        // arrange
        val product = Product(1L, 1, "title", BigDecimal.TEN, "description", "image", true)

        val favoriteList = FavoriteList(
            id = 1,
            name = "Favorite List",
            description = "Favorite List Description",
            products = setOf(product),
            enabled = false
        )

        val auth = Auth(0, "vinicius@gmail.com", "123456", true)
        val client = Client(
            id = 1,
            name = "Client",
            auth = auth,
            favoriteList = favoriteList,
            enabled = true
        )

        val favoriteListEntityRepository = mock<FavoriteListEntityRepository>()
        val productEntityRepository = mock<ProductEntityRepository>()
        val deleteFavoriteListGateway =
            DeleteFavoriteListGatewayImpl(favoriteListEntityRepository, productEntityRepository)

        // act
        deleteFavoriteListGateway.deleteFavoriteList(client)

        // assert
        val favoriteListCaptor = argumentCaptor<FavoriteListEntity>()
        verify(favoriteListEntityRepository).save(favoriteListCaptor.capture())

        val capturedFavoriteList = favoriteListCaptor.firstValue
        assertNotNull(capturedFavoriteList.client)
        assertEquals(client.id, capturedFavoriteList.client!!.id)

        val products = favoriteListCaptor.firstValue.products
        verify(productEntityRepository).saveAll(products)

        products.forEach {
            assertEquals(
                capturedFavoriteList,
                it.favoriteListEntity
            )
        }
    }
}
