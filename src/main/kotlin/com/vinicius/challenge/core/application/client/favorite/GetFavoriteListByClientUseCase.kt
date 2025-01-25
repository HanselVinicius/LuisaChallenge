package com.vinicius.challenge.core.application.client.favorite

import com.vinicius.challenge.core.application.client.favorite.gateway.GetFavoriteListByClientGateway
import com.vinicius.challenge.core.domain.client.FavoriteList
import com.vinicius.challenge.core.domain.client.service.favorite.GetFavoriteListByClientService

class GetFavoriteListByClientUseCase(private val getFavoriteListByClientGateway: GetFavoriteListByClientGateway) : GetFavoriteListByClientService {
    override fun getFavoriteListByClient(clientId: Long): FavoriteList? {
        return getFavoriteListByClientGateway.getFavoriteListByClient(clientId)
    }
}
