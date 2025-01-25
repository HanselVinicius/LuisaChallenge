package com.vinicius.challenge.core.application.client

import com.vinicius.challenge.core.application.client.favorite.EditFavoriteListUseCase
import com.vinicius.challenge.core.application.client.favorite.gateway.EditFavoriteListGateway
import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.core.domain.client.FavoriteList
import com.vinicius.challenge.core.domain.client.service.GetClientByIdService
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import kotlin.test.assertNotNull

class EditFavoriteListUseCaseTest {

    @Test
    fun shouldThrowExceptionIfClientDoesNotHaveFavoriteList() {
        // arrange
        val clientId = 1L
        val favoriteList = mock<FavoriteList>()
        val auth = mock<Auth>()
        val client = Client(1, "vinicius", auth, null, true)
        val getClientByIdService = mock<GetClientByIdService> {
            on { getClientById(clientId) }.thenReturn(client)
        }
        val editFavoriteListGateway = mock<EditFavoriteListGateway>()
        val editFavoriteListUseCase = EditFavoriteListUseCase(getClientByIdService, editFavoriteListGateway)

        // act & assert
        assertThrows(IllegalArgumentException::class.java) {
            editFavoriteListUseCase.editFavoriteListByClient(clientId, favoriteList)
        }
    }

    @Test
    fun shouldCallGatewayToEditFavoriteList() {
        // arrange
        val clientId = 1L
        val favoriteList = mock<FavoriteList>()
        val auth = mock<Auth>()
        val client = Client(1, "vinicius", auth, favoriteList, true)
        val getClientByIdService = mock<GetClientByIdService> {
            on { getClientById(clientId) }.thenReturn(client)
        }
        val editFavoriteListGateway = mock<EditFavoriteListGateway> {
            on { editFavoriteList(favoriteList) }.thenReturn(favoriteList)
        }
        val editFavoriteListUseCase = EditFavoriteListUseCase(getClientByIdService, editFavoriteListGateway)

        // act
        val result = editFavoriteListUseCase.editFavoriteListByClient(clientId, favoriteList)

        // assert
        verify(editFavoriteListGateway).editFavoriteList(favoriteList)
        assertNotNull(result)
    }
}
