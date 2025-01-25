package com.vinicius.challenge.core.domain.client.service.favorite

import com.vinicius.challenge.core.domain.client.FavoriteList

interface GetFavoriteListByClientService {
    fun getFavoriteListByClient(clientId: Long): FavoriteList?
}
