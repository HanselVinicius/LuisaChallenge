package com.vinicius.challenge.configuration.product

import com.vinicius.challenge.core.application.product.gateway.DeleteFavoriteProductGateway
import com.vinicius.challenge.core.domain.client.service.GetClientByIdService
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock

class DeleteFavoriteProductConfigTest {

    @Test
    fun shouldReturnDeleteFavoriteProductService() {
        // arrange
        val getClientByIdService = mock<GetClientByIdService>()
        val deleteFavoriteProductGateway = mock<DeleteFavoriteProductGateway>()
        val deleteFavoriteProductConfig = DeleteFavoriteProductConfig()

        // act
        val result = deleteFavoriteProductConfig.deleteFavoriteProductService(getClientByIdService, deleteFavoriteProductGateway)

        // assert
        assertNotNull(result)
    }
}
