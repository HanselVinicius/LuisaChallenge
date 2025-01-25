package com.vinicius.challenge.entrypoint.favorite

import com.vinicius.challenge.core.domain.client.FavoriteList
import com.vinicius.challenge.core.domain.client.service.favorite.DeleteFavoriteListService
import com.vinicius.challenge.core.domain.client.service.favorite.EditFavoriteListService
import com.vinicius.challenge.core.domain.client.service.favorite.GetFavoriteListByClientService
import com.vinicius.challenge.core.domain.client.service.favorite.InsertFavoriteListService
import com.vinicius.challenge.entrypoint.favorite.dto.EditFavoriteListDto
import com.vinicius.challenge.entrypoint.favorite.dto.InsertFavoriteListDto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.springframework.http.HttpStatus

class FavoriteListControllerTest {

    @Test
    fun shouldCallServiceToInsertFavoriteListAndReturn201createdWithLocation() {
        // Arrange
        val insertFavoriteListDto = InsertFavoriteListDto(
            clientId = 1L,
            name = "My Favorite List",
            description = "A list of my favorite products"
        )
        val favoriteList =
            FavoriteList(1, insertFavoriteListDto.name, insertFavoriteListDto.description, emptySet(), null, true)
        val insertFavoriteListService = mock<InsertFavoriteListService> {
            on { insertFavoriteList(insertFavoriteListDto.clientId, favoriteList) } doReturn FavoriteList(
                1,
                insertFavoriteListDto.name,
                insertFavoriteListDto.description,
                emptySet(),
                null,
                true
            )
        }

        val getFavoriteListByClientService = mock<GetFavoriteListByClientService>()
        val editFavoriteListService = mock<EditFavoriteListService>()
        val deleteFavoriteListService = mock<DeleteFavoriteListService>()
        val favoriteListController = FavoriteListController(
            insertFavoriteListService,
            getFavoriteListByClientService,
            editFavoriteListService,
            deleteFavoriteListService
        )

        // Act
        val response = favoriteListController.insertFavoriteList(insertFavoriteListDto)

        // Assert
        assertEquals(HttpStatus.CREATED, response.statusCode)
        assertNotNull(response.headers.location)
        assertEquals("/v1/favorite-list/1", response.headers.location?.path)
    }

    @Test
    fun shouldReturn404ifFavoriteListNotFoundForAClient() {
        // Arrange
        val clientId = 1L

        val insertFavoriteListService = mock<InsertFavoriteListService>()
        val getFavoriteListByClientService = mock<GetFavoriteListByClientService> {
            on { getFavoriteListByClient(clientId) } doReturn null
        }

        val editFavoriteListService = mock<EditFavoriteListService>()
        val deleteFavoriteListService = mock<DeleteFavoriteListService>()
        val favoriteListController = FavoriteListController(
            insertFavoriteListService,
            getFavoriteListByClientService,
            editFavoriteListService,
            deleteFavoriteListService
        )
        // Act
        val response = favoriteListController.getFavoriteListByClient(clientId)

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.statusCode)
    }

    @Test
    fun shouldReturnFavoriteListForAClient() {
        // Arrange
        val clientId = 1L
        val favoriteList = FavoriteList(1, "My Favorite List", "A list of my favorite products", emptySet(), null, true)

        val insertFavoriteListService = mock<InsertFavoriteListService>()
        val getFavoriteListByClientService = mock<GetFavoriteListByClientService> {
            on { getFavoriteListByClient(clientId) } doReturn favoriteList
        }

        val editFavoriteListService = mock<EditFavoriteListService>()
        val deleteFavoriteListService = mock<DeleteFavoriteListService>()
        val favoriteListController = FavoriteListController(
            insertFavoriteListService,
            getFavoriteListByClientService,
            editFavoriteListService,
            deleteFavoriteListService
        )
        // Act
        val response = favoriteListController.getFavoriteListByClient(clientId)

        // Assert
        assertEquals(HttpStatus.OK, response.statusCode)
        val body = response.body
        assertNotNull(body)
        assertEquals(favoriteList.name, body?.name)
        assertEquals(favoriteList.description, body?.description)
    }

    @Test
    fun shouldCallServiceToEditFavoriteListAndReturn201CreatedWithLocation() {
        // Arrange
        val clientId = 1L
        val editFavoriteListDto = EditFavoriteListDto(
            name = "Updated Favorite List",
            description = "Updated list of my favorite products"
        )
        val favoriteList = FavoriteList(
            id = 1,
            name = editFavoriteListDto.name,
            description = editFavoriteListDto.description,
            products = emptySet(),
            enabled = true
        )

        val editFavoriteListService = mock<EditFavoriteListService> {
            on { editFavoriteListByClient(clientId, favoriteList) } doReturn favoriteList
        }

        val insertFavoriteListService = mock<InsertFavoriteListService>()
        val getFavoriteListByClientService = mock<GetFavoriteListByClientService>()
        val deleteFavoriteListService = mock<DeleteFavoriteListService>()

        val favoriteListController = FavoriteListController(
            insertFavoriteListService,
            getFavoriteListByClientService,
            editFavoriteListService,
            deleteFavoriteListService
        )

        // Act
        val response = favoriteListController.editFavoriteListByClient(clientId, editFavoriteListDto)

        // Assert
        assertEquals(HttpStatus.OK, response.statusCode)
        assertNotNull(response.headers.location)
        assertEquals("/v1/favorite-list/1", response.headers.location?.path)
    }

    @Test
    fun shouldCallServiceToDeleteFavoriteListAndReturn204NoContent() {
        // Arrange
        val clientId = 1L
        val deleteFavoriteListService = mock<DeleteFavoriteListService>()

        val insertFavoriteListService = mock<InsertFavoriteListService>()
        val getFavoriteListByClientService = mock<GetFavoriteListByClientService>()
        val editFavoriteListService = mock<EditFavoriteListService>()

        val favoriteListController = FavoriteListController(
            insertFavoriteListService,
            getFavoriteListByClientService,
            editFavoriteListService,
            deleteFavoriteListService
        )

        // Act
        val response = favoriteListController.deleteFavoriteListByClient(clientId)

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.statusCode)
    }
}
