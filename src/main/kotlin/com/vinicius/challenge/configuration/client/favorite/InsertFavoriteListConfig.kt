package com.vinicius.challenge.configuration.client.favorite

import com.vinicius.challenge.core.application.client.favorite.InsertFavoriteListUseCase
import com.vinicius.challenge.core.application.client.favorite.gateway.InsertFavoriteListGateway
import com.vinicius.challenge.core.domain.client.service.GetClientByIdService
import com.vinicius.challenge.core.domain.client.service.favorite.InsertFavoriteListService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertFavoriteListConfig {

    @Bean
    fun insertFavoriteListService(getClientByIdService: GetClientByIdService, insertFavoriteListGateway: InsertFavoriteListGateway): InsertFavoriteListService {
        return InsertFavoriteListUseCase(getClientByIdService, insertFavoriteListGateway)
    }
}
