package com.vinicius.challenge.gateway.client.entity

import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.core.domain.client.FavoriteList
import com.vinicius.challenge.gateway.auth.entity.AuthEntity
import org.junit.jupiter.api.Test

class ClientEntityMapperTest {
    @Test
    fun shouldMapToEntity() {
        // arrange
        val auth = Auth(1, "principal", "credentials", true)
        val favoriteList = FavoriteList(1, "lista", "descricao", emptySet(), null, true)
        val client = Client(1, "name", auth, favoriteList, true)

        // act
        val clientEntity = ClientEntityMapper.toEntity(client)

        // assert
        assert(clientEntity.id == client.id)
        assert(clientEntity.name == client.name)
        assert(clientEntity.auth.id == client.auth.id)
    }

    @Test
    fun shouldMapToDomain() {
        // arrange
        val authEntity = AuthEntity(1, "principal", "credentials", true)
        val favoriteListEntity = FavoriteListEntity(1, "lista", "descricao", emptySet(), null, true)
        val clientEntity = ClientEntity(1, "name", authEntity, favoriteListEntity, true)

        // act
        val client = ClientEntityMapper.toDomain(clientEntity)

        // assert
        assert(client.id == clientEntity.id)
        assert(client.name == clientEntity.name)
        assert(client.auth.id == clientEntity.auth.id)
    }
}
