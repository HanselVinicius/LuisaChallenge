package com.vinicius.challenge.gateway.client.entity

import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.gateway.auth.entity.AuthEntityMapper
import com.vinicius.challenge.gateway.client.favorite.entity.FavoriteListEntityMapper

object ClientEntityMapper {
    fun toEntity(client: Client): ClientEntity {
        return ClientEntity(
            id = client.id,
            name = client.name,
            auth = AuthEntityMapper.toEntity(client.auth),
            favoriteLists = if (client.favoriteList != null) FavoriteListEntityMapper.toEntitySimple(client.favoriteList!!) else mutableListOf(),
            enabled = client.enabled
        )
    }

    fun toDomain(clientEntity: ClientEntity): Client {
        return Client(
            id = clientEntity.id,
            name = clientEntity.name,
            auth = AuthEntityMapper.toDomain(clientEntity.auth),
            favoriteList = if (clientEntity.favoriteLists.size > 0) FavoriteListEntityMapper.toDomainSimple(clientEntity.favoriteLists.first()) else null,
            enabled = clientEntity.enabled
        )
    }
}
