package com.vinicius.challenge.configuration.client.favorite

import com.vinicius.challenge.core.application.client.favorite.DeleteFavoriteListUseCase
import com.vinicius.challenge.core.application.client.favorite.gateway.DeleteFavoriteListGateway
import com.vinicius.challenge.core.domain.client.service.GetClientByIdService
import com.vinicius.challenge.core.domain.client.service.favorite.DeleteFavoriteListService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DeleteFavoriteListConfig {

    @Bean
    fun deleteFavoriteListService(
        getClientByIdService: GetClientByIdService,
        deleteFavoriteListGateway: DeleteFavoriteListGateway
    ): DeleteFavoriteListService {
        return DeleteFavoriteListUseCase(getClientByIdService, deleteFavoriteListGateway)
    }
}
