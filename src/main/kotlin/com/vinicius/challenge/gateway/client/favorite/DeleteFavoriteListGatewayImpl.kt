package com.vinicius.challenge.gateway.client.favorite

import com.vinicius.challenge.core.application.client.favorite.gateway.DeleteFavoriteListGateway
import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.gateway.client.entity.ClientEntityMapper
import com.vinicius.challenge.gateway.client.favorite.entity.FavoriteListEntityRepository
import com.vinicius.challenge.gateway.product.entity.ProductEntityRepository
import org.springframework.stereotype.Component

@Component
class DeleteFavoriteListGatewayImpl(
    private val favoriteListEntityRepository: FavoriteListEntityRepository,
    private val productEntityRepository: ProductEntityRepository
) :
    DeleteFavoriteListGateway {
    override fun deleteFavoriteList(client: Client) {
        val clientEntity = ClientEntityMapper.toEntity(client)
        clientEntity.favoriteLists.firstOrNull()?.client = clientEntity
        clientEntity.favoriteLists.firstOrNull()?.products?.forEach { it.favoriteListEntity = clientEntity.favoriteLists.first() }
        favoriteListEntityRepository.save(clientEntity.favoriteLists.first())
        productEntityRepository.saveAll(clientEntity.favoriteLists.first().products)
    }
}
