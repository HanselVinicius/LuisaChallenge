package com.vinicius.challenge.configuration.client.favorite

import com.vinicius.challenge.core.application.client.favorite.gateway.EditFavoriteListGateway
import com.vinicius.challenge.core.domain.client.service.GetClientByIdService
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock

class EditFavoriteListConfigTest {
    @Test
    fun testEditFavoriteListService() {
        // arrange
        val editFavoriteListConfig = EditFavoriteListConfig()
        val getClientByIdService = mock<GetClientByIdService>()
        val editFavoriteListGateway = mock<EditFavoriteListGateway>()
        // act
        val result = editFavoriteListConfig.editFavoriteListService(getClientByIdService, editFavoriteListGateway)

        // assert
        assertNotNull(result)
    }
}
