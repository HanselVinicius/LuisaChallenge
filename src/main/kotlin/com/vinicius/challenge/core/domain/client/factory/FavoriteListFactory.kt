package com.vinicius.challenge.core.domain.client.factory

import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.core.domain.client.FavoriteList

object FavoriteListFactory {
    fun createFavoriteList(client: Client, name: String, description: String): FavoriteList {
        return FavoriteList(
            id = null,
            name = name,
            description = description,
            client = client,
            products = emptySet(),
            enabled = true
        )
    }
}
