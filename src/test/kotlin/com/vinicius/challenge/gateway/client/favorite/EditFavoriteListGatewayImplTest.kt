package com.vinicius.challenge.gateway.client.favorite

import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.core.domain.client.FavoriteList
import com.vinicius.challenge.gateway.client.entity.ClientEntityMapper
import com.vinicius.challenge.gateway.client.favorite.entity.FavoriteListEntityMapper
import com.vinicius.challenge.gateway.client.favorite.entity.FavoriteListEntityRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

class EditFavoriteListGatewayImplTest {

    @Test
    fun shouldEditFavoriteList() {
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
        favoriteList.client = client
        val favoriteListEntity = FavoriteListEntityMapper.toEntitySimple(favoriteList)
        val clientEntity = ClientEntityMapper.toEntity(client)
        favoriteListEntity.client = clientEntity
        val favoriteListEntityRepository = mock<FavoriteListEntityRepository> {
            onGeneric { save(any()) } doReturn favoriteListEntity
        }

        // Instancia o gateway
        val editFavoriteListGatewayImpl = EditFavoriteListGatewayImpl(favoriteListEntityRepository)

        // act
        val result = editFavoriteListGatewayImpl.editFavoriteList(favoriteList)

        // assert
        assertEquals(favoriteList.id, result.id)
        assertEquals(favoriteList.name, result.name)
        assertEquals(favoriteList.description, result.description)
        assertEquals(favoriteList.products, result.products)
        assertEquals(favoriteList.enabled, result.enabled)
    }
}
