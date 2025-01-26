package com.vinicius.challenge.configuration.product

import com.vinicius.challenge.core.application.product.DeleteFavoriteProductUseCase
import com.vinicius.challenge.core.application.product.gateway.DeleteFavoriteProductGateway
import com.vinicius.challenge.core.domain.client.service.GetClientByIdService
import com.vinicius.challenge.core.domain.product.service.DeleteFavoriteProductService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DeleteFavoriteProductConfig {

    @Bean
    fun deleteFavoriteProductService(
        getClientByIdService: GetClientByIdService,
        deleteFavoriteProductGateway: DeleteFavoriteProductGateway
    ): DeleteFavoriteProductService {
        return DeleteFavoriteProductUseCase(getClientByIdService, deleteFavoriteProductGateway)
    }
}
