package com.vinicius.challenge.core.domain.client.service.favorite

import com.vinicius.challenge.core.domain.client.FavoriteList

interface InsertFavoriteListService {
    fun insertFavoriteList(clientId: Long, favoriteList: FavoriteList): FavoriteList
}
