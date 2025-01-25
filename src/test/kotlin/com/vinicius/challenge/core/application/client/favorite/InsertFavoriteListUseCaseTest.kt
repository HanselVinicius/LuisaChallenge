package com.vinicius.challenge.core.application.client.favorite

import com.vinicius.challenge.core.application.client.favorite.gateway.InsertFavoriteListGateway
import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.core.domain.client.factory.ClientFactory
import com.vinicius.challenge.core.domain.client.factory.FavoriteListFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class InsertFavoriteListUseCaseTest {

    @Test
    fun shouldCallGatewayToInsertFavoriteList() {
        // arrange
        val auth = Auth(1L, "username", "password", true)
        val client = ClientFactory.createClient(auth, "name")
        val favoriteList = FavoriteListFactory.createFavoriteList(client, "name", "description")
        val insertFavoriteListGateway = mock<InsertFavoriteListGateway> {
            on { insertFavoriteList(any()) }.thenReturn(favoriteList)
        }
        val insertFavoriteListUseCase = InsertFavoriteListUseCase(insertFavoriteListGateway)
        client.favoriteList = favoriteList
        // act
        val result = insertFavoriteListUseCase.insertFavoriteList(client)

        // assert
        verify(insertFavoriteListGateway).insertFavoriteList(client)
        assertEquals(favoriteList, result)
    }
}
