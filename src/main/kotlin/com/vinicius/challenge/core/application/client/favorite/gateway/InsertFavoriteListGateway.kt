package com.vinicius.challenge.core.application.client.favorite.gateway

import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.core.domain.client.FavoriteList

interface InsertFavoriteListGateway {
    fun insertFavoriteList(client: Client): FavoriteList
}
