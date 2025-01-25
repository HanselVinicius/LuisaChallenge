package com.vinicius.challenge.core.domain.client.factory

import com.vinicius.challenge.core.domain.client.Client
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock

class FavoriteListFactoryTest {
    @Test
    fun shouldCreateFavoriteList() {
        // arrange
        val name = "name"
        val description = "description"
        val client = mock<Client>()

        // act
        val favoriteList = FavoriteListFactory.createFavoriteList(client, name, description)

        // assert
        assertNotNull(favoriteList)
        assertEquals(name, favoriteList.name)
        assertEquals(description, favoriteList.description)
    }
}
