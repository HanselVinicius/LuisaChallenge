package com.vinicius.challenge.core.application.client.favorite

import com.vinicius.challenge.core.application.client.favorite.gateway.InsertFavoriteListGateway
import com.vinicius.challenge.core.domain.client.FavoriteList
import com.vinicius.challenge.core.domain.client.service.GetClientByIdService
import com.vinicius.challenge.core.domain.client.service.favorite.InsertFavoriteListService

class InsertFavoriteListUseCase(private val getClientByIdService: GetClientByIdService, private val insertFavoriteListGateway: InsertFavoriteListGateway) : InsertFavoriteListService {
    override fun insertFavoriteList(clientId: Long, favoriteList: FavoriteList): FavoriteList {
        val client = getClientByIdService.getClientById(clientId)
        client.insertFavoriteList(favoriteList)
        return insertFavoriteListGateway.insertFavoriteList(client)
    }
}
