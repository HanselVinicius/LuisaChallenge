package com.vinicius.challenge.core.application.client

import com.vinicius.challenge.core.application.client.favorite.GetFavoriteListByClientUseCase
import com.vinicius.challenge.core.application.client.favorite.gateway.GetFavoriteListByClientGateway
import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.core.domain.client.factory.ClientFactory
import com.vinicius.challenge.core.domain.client.factory.FavoriteListFactory
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import kotlin.test.assertEquals
import kotlin.test.assertNull

class GetFavoriteListByClientUseCaseTest {

    @Test
    fun shouldCallGatewayToGetAFavoriteListByClientAndReturnIfExists() {
        // arrange
        val auth = mock<Auth>()
        val client = ClientFactory.createClient(auth = auth, "client")
        val clientId = 1L
        val favoriteList = FavoriteListFactory.createFavoriteList(client = client, "favoriteList", "favoriteList")
        val getFavoriteListByClientGateway = mock<GetFavoriteListByClientGateway> {
            on { getFavoriteListByClient(clientId) } doReturn favoriteList
        }
        val getFavoriteListByClientUseCase = GetFavoriteListByClientUseCase(getFavoriteListByClientGateway)
        // act
        val result = getFavoriteListByClientUseCase.getFavoriteListByClient(clientId)

        // assert
        verify(getFavoriteListByClientGateway).getFavoriteListByClient(clientId)
        assertEquals(favoriteList, result)
    }

    @Test
    fun shouldCallGatewayToGetAFavoriteListByClientAndReturnNullIfNotExists() {
        // arrange
        val getFavoriteListByClientGateway = mock<GetFavoriteListByClientGateway>()
        val clientId = 1L

        val getFavoriteListByClientUseCase = GetFavoriteListByClientUseCase(getFavoriteListByClientGateway)
        // act
        val result = getFavoriteListByClientUseCase.getFavoriteListByClient(clientId)

        // assert
        verify(getFavoriteListByClientGateway).getFavoriteListByClient(clientId)
        assertNull(result)
    }
}
