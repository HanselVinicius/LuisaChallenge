package com.vinicius.challenge.core.application.client.favorite

import com.vinicius.challenge.core.application.client.favorite.gateway.DeleteFavoriteListGateway
import com.vinicius.challenge.core.domain.client.service.GetClientByIdService
import com.vinicius.challenge.core.domain.client.service.favorite.DeleteFavoriteListService

class DeleteFavoriteListUseCase(private val getClientByIdService: GetClientByIdService, private val deleteFavoriteListGateway: DeleteFavoriteListGateway) : DeleteFavoriteListService {
    override fun deleteFavoriteList(clientId: Long) {
        val client = getClientByIdService.getClientById(clientId)
        client.deleteFavoriteList()
        deleteFavoriteListGateway.deleteFavoriteList(client)
    }
}
