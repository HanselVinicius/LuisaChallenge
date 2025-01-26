package com.vinicius.challenge.core.domain.client

import com.vinicius.challenge.core.domain.auth.Auth
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FavoriteListTest {
    @Test
    fun shouldUpdateFieldsCorrectly() {
        // Arrange
        val client = Client(1, "test", Auth(0, "principal", "credentials", true), null, true)

        val favoriteListToEdit = FavoriteList(
            id = 1,
            name = "old Favorite",
            description = "This is a old favorite list",
            client = client,
            products = emptySet(),
            enabled = true
        )

        val favoriteList = FavoriteList(
            id = 1,
            name = "New Favorite",
            description = "This is a new favorite list",
            client = client,
            products = emptySet(),
            enabled = true
        )

        // Act
        favoriteListToEdit.editFavoriteList(favoriteList)

        // Assert
        assertEquals("New Favorite", favoriteList.name)
        assertEquals("This is a new favorite list", favoriteList.description)
    }
}
