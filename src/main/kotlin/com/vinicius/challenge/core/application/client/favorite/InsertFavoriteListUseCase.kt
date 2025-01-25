package com.vinicius.challenge.core.application.client.favorite

import com.vinicius.challenge.core.application.client.favorite.gateway.InsertFavoriteListGateway
import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.core.domain.client.FavoriteList
import com.vinicius.challenge.core.domain.client.service.favorite.InsertFavoriteListService

class InsertFavoriteListUseCase(private val insertFavoriteListGateway: InsertFavoriteListGateway) : InsertFavoriteListService {
    override fun insertFavoriteList(client: Client): FavoriteList {
        if (client.favoriteList == null) {
            throw IllegalArgumentException("Favorite list is required")
        }
        return insertFavoriteListGateway.insertFavoriteList(client)
    }
}
