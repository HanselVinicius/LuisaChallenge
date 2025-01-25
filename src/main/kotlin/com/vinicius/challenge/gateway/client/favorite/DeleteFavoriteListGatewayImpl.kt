package com.vinicius.challenge.gateway.client.favorite

import com.vinicius.challenge.core.application.client.favorite.gateway.DeleteFavoriteListGateway
import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.gateway.client.entity.ClientEntityMapper
import com.vinicius.challenge.gateway.client.favorite.entity.FavoriteListEntityRepository
import org.springframework.stereotype.Component

@Component
class DeleteFavoriteListGatewayImpl(private val favoriteListEntityRepository: FavoriteListEntityRepository) :
    DeleteFavoriteListGateway {
    override fun deleteFavoriteList(client: Client) {
        val clientEntity = ClientEntityMapper.toEntity(client)
        favoriteListEntityRepository.save(clientEntity.favoriteListEntity!!)
    }
}
