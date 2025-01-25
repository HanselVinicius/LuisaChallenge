package com.vinicius.challenge.core.domain.client.service.favorite

import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.core.domain.client.FavoriteList

interface InsertFavoriteListService {
    fun insertFavoriteList(client: Client): FavoriteList
}
