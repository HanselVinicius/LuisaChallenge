package com.vinicius.challenge.gateway.client.favorite

import com.vinicius.challenge.core.application.client.favorite.gateway.EditFavoriteListGateway
import com.vinicius.challenge.core.domain.client.FavoriteList
import com.vinicius.challenge.gateway.client.entity.ClientEntityMapper
import com.vinicius.challenge.gateway.client.favorite.entity.FavoriteListEntityMapper
import com.vinicius.challenge.gateway.client.favorite.entity.FavoriteListEntityRepository
import org.springframework.stereotype.Component

@Component
class EditFavoriteListGatewayImpl(private val favoriteListEntityRepository: FavoriteListEntityRepository) : EditFavoriteListGateway {
    override fun editFavoriteList(favoriteList: FavoriteList): FavoriteList {
        val favoriteListEntity = FavoriteListEntityMapper.toEntitySimple(favoriteList)
        val clientEntity = ClientEntityMapper.toEntity(favoriteList.client!!)
        favoriteListEntity.client = clientEntity
        val editedFavoriteList = favoriteListEntityRepository.save(favoriteListEntity)
        return FavoriteListEntityMapper.toDomainSimple(editedFavoriteList)
    }
}
