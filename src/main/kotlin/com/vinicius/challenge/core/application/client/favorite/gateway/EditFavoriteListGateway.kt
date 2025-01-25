package com.vinicius.challenge.core.application.client.favorite.gateway

import com.vinicius.challenge.core.domain.client.FavoriteList

interface EditFavoriteListGateway {
    fun editFavoriteList(favoriteList: FavoriteList): FavoriteList
}
