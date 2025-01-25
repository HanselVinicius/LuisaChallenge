package com.vinicius.challenge.configuration.client.favorite

import com.vinicius.challenge.core.application.client.favorite.EditFavoriteListUseCase
import com.vinicius.challenge.core.application.client.favorite.gateway.EditFavoriteListGateway
import com.vinicius.challenge.core.domain.client.service.GetClientByIdService
import com.vinicius.challenge.core.domain.client.service.favorite.EditFavoriteListService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class EditFavoriteListConfig {
    @Bean
    fun editFavoriteListService(getClientByIdService: GetClientByIdService, editFavoriteListGateway: EditFavoriteListGateway): EditFavoriteListService {
        return EditFavoriteListUseCase(getClientByIdService, editFavoriteListGateway)
    }
}
