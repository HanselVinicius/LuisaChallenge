package com.vinicius.challenge.configuration.product

import com.vinicius.challenge.core.application.product.gateway.FavoriteProductGateway
import com.vinicius.challenge.core.domain.client.service.GetClientByIdService
import com.vinicius.challenge.core.domain.client.service.SendNotificationService
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock

class FavoriteProductConfigTest {

    @Test
    fun shouldReturnFavoriteProductService() {
        // arrange
        val getClientByIdService = mock<GetClientByIdService>()
        val favoriteProductGateway = mock<FavoriteProductGateway>()
        val sendNotificationService = mock<SendNotificationService>()
        val favoriteProductConfig = FavoriteProductConfig()

        // act
        val result = favoriteProductConfig.favoriteProductService(getClientByIdService, favoriteProductGateway, sendNotificationService)

        // assert
        assertNotNull(result)
    }
}
