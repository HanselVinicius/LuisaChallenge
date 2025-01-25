package com.vinicius.challenge.configuration.client.favorite

import com.vinicius.challenge.core.application.client.favorite.GetFavoriteListByClientUseCase
import com.vinicius.challenge.core.application.client.favorite.gateway.GetFavoriteListByClientGateway
import com.vinicius.challenge.core.domain.client.service.favorite.GetFavoriteListByClientService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GetFavoriteListByClientConfig {

    @Bean
    fun getFavoriteListByClientService(getFavoriteListByClientGateway: GetFavoriteListByClientGateway): GetFavoriteListByClientService {
        return GetFavoriteListByClientUseCase(getFavoriteListByClientGateway)
    }
}
