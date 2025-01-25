package com.vinicius.challenge.gateway.client.favorite

import com.vinicius.challenge.core.application.client.favorite.gateway.GetFavoriteListByClientGateway
import com.vinicius.challenge.core.domain.client.FavoriteList
import com.vinicius.challenge.gateway.client.favorite.entity.FavoriteListEntityMapper
import com.vinicius.challenge.gateway.client.favorite.entity.FavoriteListEntityRepository
import org.springframework.stereotype.Component

@Component
class GetFavoriteListByClientGatewayImpl(private val favoriteListEntityRepository: FavoriteListEntityRepository) : GetFavoriteListByClientGateway {
    override fun getFavoriteListByClient(clientId: Long): FavoriteList? {
        val favoriteListEntity = favoriteListEntityRepository.findFavoriteListEntityByClientId(clientId) ?: return null
        return FavoriteListEntityMapper.toDomainSimple(favoriteListEntity)
    }
}
