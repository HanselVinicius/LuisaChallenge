package com.vinicius.challenge.gateway.client.favorite

import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.core.domain.client.FavoriteList
import com.vinicius.challenge.gateway.client.favorite.entity.FavoriteListEntityRepository
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class DeleteFavoriteListGatewayImplTest {
    @Test
    fun shouldDeleteFavoriteList() {
        // arrange
        val favoriteList = FavoriteList(
            id = 1,
            name = "Favorite List",
            description = "Favorite List Description",
            products = setOf(),
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
        val deleteFavoriteListGateway = DeleteFavoriteListGatewayImpl(favoriteListEntityRepository)
        // act
        deleteFavoriteListGateway.deleteFavoriteList(client)
        // assert
        verify(favoriteListEntityRepository).save(any())
    }
}
