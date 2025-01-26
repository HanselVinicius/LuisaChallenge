package com.vinicius.challenge.configuration.product

import com.vinicius.challenge.core.application.product.FavoriteProductUseCase
import com.vinicius.challenge.core.application.product.gateway.FavoriteProductGateway
import com.vinicius.challenge.core.domain.client.service.GetClientByIdService
import com.vinicius.challenge.core.domain.client.service.SendNotificationService
import com.vinicius.challenge.core.domain.product.service.FavoriteProductService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FavoriteProductConfig {

    @Bean
    fun favoriteProductService(
        getClientByIdService: GetClientByIdService,
        favoriteProductGateway: FavoriteProductGateway,
        sendNotificationService: SendNotificationService
    ): FavoriteProductService {
        return FavoriteProductUseCase(getClientByIdService, favoriteProductGateway, sendNotificationService)
    }
}
