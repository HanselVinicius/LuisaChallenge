package com.vinicius.challenge.gateway.client.favorite

import com.vinicius.challenge.gateway.client.favorite.entity.FavoriteListEntity
import com.vinicius.challenge.gateway.client.favorite.entity.FavoriteListEntityRepository
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import kotlin.test.assertEquals

class GetFavoriteListByClientGatewayImplTest {

    @Test
    fun shouldGetFavoriteListByClientIfExists() {
        // arrange
        val clientId = 1L
        val favoriteListEntity = FavoriteListEntity(
            id = 1L,
            client = null,
            name = "name",
            description = "description",
            enabled = true
        )
        val favoriteListEntityRepository = mock<FavoriteListEntityRepository> {
            on { findFavoriteListEntityByClientId(clientId) } doReturn favoriteListEntity
        }
        val getFavoriteListByClientGatewayImpl = GetFavoriteListByClientGatewayImpl(favoriteListEntityRepository)
        // act
        val result = getFavoriteListByClientGatewayImpl.getFavoriteListByClient(clientId)

        // assert
        verify(favoriteListEntityRepository).findFavoriteListEntityByClientId(clientId)
        assertEquals(favoriteListEntity.id, result!!.id)
        assertEquals(favoriteListEntity.name, result.name)
        assertEquals(favoriteListEntity.description, result.description)
        assertEquals(favoriteListEntity.enabled, result.enabled)
    }
}
