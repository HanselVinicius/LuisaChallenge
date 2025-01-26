package com.vinicius.challenge.configuration.client.favorite

import com.vinicius.challenge.core.application.client.favorite.gateway.GetFavoriteListByClientGateway
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock

class GetFavoriteListByClientConfigTest {

    @Test
    fun testGetFavoriteListByClientService() {
        // arrange
        val getFavoriteListByClientConfig = GetFavoriteListByClientConfig()
        val getFavoriteListByClientGateway = mock<GetFavoriteListByClientGateway>()
        // act
        val result = getFavoriteListByClientConfig.getFavoriteListByClientService(getFavoriteListByClientGateway)
        // assert
        assertNotNull(result)
    }
}
