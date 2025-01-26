package com.vinicius.challenge.configuration.client.favorite

import com.vinicius.challenge.core.application.client.favorite.gateway.DeleteFavoriteListGateway
import com.vinicius.challenge.core.domain.client.service.GetClientByIdService
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock

class DeleteFavoriteListConfigTest {
    @Test
    fun testDeleteFavoriteListService() {
        // arrange
        val getClientByIdService = mock<GetClientByIdService>()
        val deleteFavoriteListGateway = mock<DeleteFavoriteListGateway>()
        val deleteFavoriteListConfig = DeleteFavoriteListConfig()

        // act
        val result = deleteFavoriteListConfig.deleteFavoriteListService(getClientByIdService, deleteFavoriteListGateway)

        // assert
        assertNotNull(result)
    }
}
