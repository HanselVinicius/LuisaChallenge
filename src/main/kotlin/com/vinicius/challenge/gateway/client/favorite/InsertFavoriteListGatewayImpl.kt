package com.vinicius.challenge.gateway.client.favorite

import com.vinicius.challenge.core.application.client.favorite.gateway.InsertFavoriteListGateway
import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.core.domain.client.FavoriteList
import com.vinicius.challenge.gateway.client.entity.ClientEntityMapper
import com.vinicius.challenge.gateway.client.favorite.entity.FavoriteListEntityMapper
import com.vinicius.challenge.gateway.client.favorite.entity.FavoriteListEntityRepository
import org.springframework.stereotype.Component

@Component
class InsertFavoriteListGatewayImpl(private val favoriteListEntityRepository: FavoriteListEntityRepository) : InsertFavoriteListGateway {
    override fun insertFavoriteList(client: Client): FavoriteList {
        val clientEntity = ClientEntityMapper.toEntity(client)
        clientEntity.favoriteLists.first().client = clientEntity
        return FavoriteListEntityMapper.toDomainSimple(favoriteListEntityRepository.save(clientEntity.favoriteLists.first()))
    }
}
