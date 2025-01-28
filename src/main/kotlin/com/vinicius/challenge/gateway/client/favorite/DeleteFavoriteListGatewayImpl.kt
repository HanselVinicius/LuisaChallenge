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
        clientEntity.favoriteListEntity!!.client = clientEntity
        clientEntity.favoriteListEntity!!.products.forEach { it.favoriteListEntity = clientEntity.favoriteListEntity }
        favoriteListEntityRepository.save(clientEntity.favoriteListEntity!!)
        productEntityRepository.saveAll(clientEntity.favoriteListEntity!!.products)
    }
}
