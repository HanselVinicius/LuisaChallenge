package com.vinicius.challenge.core.application.client.favorite

import com.vinicius.challenge.core.application.client.favorite.gateway.EditFavoriteListGateway
import com.vinicius.challenge.core.domain.client.FavoriteList
import com.vinicius.challenge.core.domain.client.service.GetClientByIdService
import com.vinicius.challenge.core.domain.client.service.favorite.EditFavoriteListService

class EditFavoriteListUseCase(
    private val getClientByIdService: GetClientByIdService,
    private val editFavoriteListGateway: EditFavoriteListGateway
) : EditFavoriteListService {
    override fun editFavoriteListByClient(clientId: Long, favoriteList: FavoriteList): FavoriteList {
        val client = getClientByIdService.getClientById(clientId)
        client.editFavoriteList(favoriteList)
        return editFavoriteListGateway.editFavoriteList(client.favoriteList!!)
    }
}
