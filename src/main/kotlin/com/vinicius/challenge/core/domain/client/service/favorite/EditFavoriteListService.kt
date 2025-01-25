package com.vinicius.challenge.core.domain.client.service.favorite

import com.vinicius.challenge.core.domain.client.FavoriteList

interface EditFavoriteListService {
    fun editFavoriteListByClient(clientId: Long, favoriteList: FavoriteList): FavoriteList
}
