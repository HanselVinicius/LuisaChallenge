package com.vinicius.challenge.core.application.client.favorite

import com.vinicius.challenge.core.application.client.favorite.gateway.DeleteFavoriteListGateway
import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.core.domain.client.FavoriteList
import com.vinicius.challenge.core.domain.client.service.GetClientByIdService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class DeleteFavoriteListUseCaseTest {

    @Test
    fun shouldDeleteFavoriteList() {
        // arrange
        val favoriteList = FavoriteList(
            id = 1,
            name = "Favorite List",
            description = "Favorite List Description",
            products = setOf(),
            enabled = true
        )

        val auth = Auth(0, "vinicius@gmail.com", "123456", true)
        val client = Client(
            id = 1,
            name = "Client",
            auth = auth,
            favoriteList = favoriteList,
            enabled = true
        )
        val getClientByIdService = mock<GetClientByIdService> {
            on(it.getClientById(1)) doReturn client
        }

        val deleteFavoriteListGateway = mock<DeleteFavoriteListGateway>()
        val deleteFavoriteListUseCase = DeleteFavoriteListUseCase(getClientByIdService, deleteFavoriteListGateway)
        val clientId = 1L
        // act
        deleteFavoriteListUseCase.deleteFavoriteList(clientId)
        // assert
        verify(getClientByIdService).getClientById(clientId)
        verify(deleteFavoriteListGateway).deleteFavoriteList(client)
        assertEquals(false, favoriteList.enabled)
    }

    @Test
    fun shouldThrowExceptionIfClientDoesNotHaveFavoriteList() {
        // arrange
        val clientId = 1L
        val auth = mock<Auth>()
        val client = Client(1, "vinicius", auth, null, true)
        val getClientByIdService = mock<GetClientByIdService> {
            on { getClientById(clientId) }.thenReturn(client)
        }
        val deleteFavoriteListGateway = mock<DeleteFavoriteListGateway>()
        val deleteFavoriteListUseCase = DeleteFavoriteListUseCase(getClientByIdService, deleteFavoriteListGateway)

        // act & assert
        assertThrows(IllegalArgumentException::class.java) {
            deleteFavoriteListUseCase.deleteFavoriteList(clientId)
        }
    }
}
