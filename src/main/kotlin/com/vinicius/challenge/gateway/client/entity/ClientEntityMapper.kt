package com.vinicius.challenge.gateway.client.entity

import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.gateway.auth.entity.AuthEntityMapper

object ClientEntityMapper {
    fun toEntity(client: Client): ClientEntity {
        return ClientEntity(
            id = client.id,
            name = client.name,
            auth = AuthEntityMapper.toEntity(client.auth),
            favoriteListEntity = if (client.favoriteList != null) FavoriteListEntityMapper.toEntity(client.favoriteList) else null,
            enabled = client.enabled
        )
    }

    fun toDomain(clientEntity: ClientEntity): Client {
        return Client(
            id = clientEntity.id,
            name = clientEntity.name,
            auth = AuthEntityMapper.toDomain(clientEntity.auth),
            favoriteList = if (clientEntity.favoriteListEntity != null) FavoriteListEntityMapper.toDomainSimple(clientEntity.favoriteListEntity!!) else null,
            enabled = clientEntity.enabled
        )
    }
}
