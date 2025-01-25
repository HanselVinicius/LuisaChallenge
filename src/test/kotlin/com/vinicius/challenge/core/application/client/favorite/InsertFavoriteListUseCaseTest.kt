package com.vinicius.challenge.core.application.client.favorite

import com.vinicius.challenge.core.application.client.favorite.gateway.InsertFavoriteListGateway
import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.core.domain.client.factory.FavoriteListFactory
import com.vinicius.challenge.core.domain.client.service.GetClientByIdService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class InsertFavoriteListUseCaseTest {

    @Test
    fun shouldCallGatewayToInsertFavoriteList() {
        // arrange
        val auth = Auth(1L, "username", "password", true)
        val client = Client(1, "Vinicius", auth, null, true)
        val favoriteList = FavoriteListFactory.createFavoriteList(client, "name", "description")
        val insertFavoriteListGateway = mock<InsertFavoriteListGateway> {
            on { insertFavoriteList(any()) }.thenReturn(favoriteList)
        }
        val getClientByIdService = mock<GetClientByIdService> {
            on { getClientById(any()) }.thenReturn(client)
        }
        val insertFavoriteListUseCase = InsertFavoriteListUseCase(getClientByIdService, insertFavoriteListGateway)
        // act
        val result = insertFavoriteListUseCase.insertFavoriteList(client.id!!, favoriteList)

        // assert
        verify(insertFavoriteListGateway).insertFavoriteList(client)
        assertEquals(favoriteList, result)
    }

    @Test
    fun shouldThrowExceptionWhenClientAlreadyHasFavoriteList() {
        // arrange
        val auth = Auth(1L, "username", "password", true)
        val client = Client(1, "Vinicius", auth, null, true)
        val favoriteList = FavoriteListFactory.createFavoriteList(client, "name", "description")
        client.favoriteList = favoriteList

        val insertFavoriteListGateway = mock<InsertFavoriteListGateway>()
        val getClientByIdService = mock<GetClientByIdService> {
            on { getClientById(any()) }.thenReturn(client)
        }
        val insertFavoriteListUseCase = InsertFavoriteListUseCase(getClientByIdService, insertFavoriteListGateway)

        // act & assert
        val exception = assertThrows(IllegalArgumentException::class.java) {
            insertFavoriteListUseCase.insertFavoriteList(client.id!!, favoriteList)
        }
        assertEquals("Client already has one favorite list", exception.message)
    }
}
