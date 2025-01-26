package com.vinicius.challenge.configuration.client.favorite

import com.vinicius.challenge.core.application.client.favorite.gateway.InsertFavoriteListGateway
import com.vinicius.challenge.core.domain.client.service.GetClientByIdService
import org.junit.jupiter.api.Assertions.assertNotNull
import org.mockito.Mockito.mock
import kotlin.test.Test

class InsertFavoriteListConfigTest {
    @Test
    fun shouldCreateInsertFavoriteListServiceBean() {
        // Arrange
        val getClientByIdService = mock<GetClientByIdService>()
        val insertFavoriteListGateway = mock<InsertFavoriteListGateway>()
        val insertFavoriteListConfig = InsertFavoriteListConfig()
        // Act
        val result = insertFavoriteListConfig.insertFavoriteListService(getClientByIdService, insertFavoriteListGateway)

        // Assert
        assertNotNull(result)
    }
}
