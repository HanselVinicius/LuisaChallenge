package com.vinicius.challenge.core.application.client.favorite.gateway

import com.vinicius.challenge.core.domain.client.Client

interface DeleteFavoriteListGateway {
    fun deleteFavoriteList(client: Client)
}
