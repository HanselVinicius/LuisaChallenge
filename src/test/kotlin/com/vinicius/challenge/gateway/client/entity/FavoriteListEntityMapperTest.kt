package com.vinicius.challenge.gateway.client.entity

import com.vinicius.challenge.core.domain.client.FavoriteList
import com.vinicius.challenge.core.domain.product.Product
import com.vinicius.challenge.gateway.client.favorite.entity.FavoriteListEntity
import com.vinicius.challenge.gateway.client.favorite.entity.FavoriteListEntityMapper
import com.vinicius.challenge.gateway.product.entity.ProductEntity
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class FavoriteListEntityMapperTest {

    @Test
    fun shouldMapToEntitySimpleSimple() {
        // arrange
        val product = Product(
            id = 1L,
            title = "Product 1",
            price = BigDecimal("100.00"),
            description = "Product 1 description",
            image = "image.jpg",
            enabled = true
        )
        val favoriteList = FavoriteList(
            id = 1L,
            name = "Favorite List 1",
            description = "Description of Favorite List 1",
            products = setOf(product),
            enabled = true
        )

        // act
        val favoriteListEntity = FavoriteListEntityMapper.toEntitySimple(favoriteList)

        // assert
        assertEquals(favoriteList.id, favoriteListEntity.id)
        assertEquals(favoriteList.name, favoriteListEntity.name)
        assertEquals(favoriteList.description, favoriteListEntity.description)
        assertEquals(favoriteList.enabled, favoriteListEntity.enabled)
        assertEquals(1, favoriteListEntity.products.size)
        assertEquals("Product 1", favoriteListEntity.products.first().title)
    }

    @Test
    fun shouldMapToDomainSimple() {
        // arrange
        val productEntity = ProductEntity(
            id = 1L,
            title = "Product 1",
            price = BigDecimal("100.00"),
            description = "Product 1 description",
            image = "image.jpg",
            favoriteListEntity = null,
            enabled = true
        )
        val favoriteListEntity = FavoriteListEntity(
            id = 1L,
            name = "Favorite List 1",
            description = "Description of Favorite List 1",
            products = setOf(productEntity),
            enabled = true
        )

        // act
        val favoriteList = FavoriteListEntityMapper.toDomainSimple(favoriteListEntity)

        // assert
        assertEquals(favoriteListEntity.id, favoriteList.id)
        assertEquals(favoriteListEntity.name, favoriteList.name)
        assertEquals(favoriteListEntity.description, favoriteList.description)
        assertEquals(favoriteListEntity.enabled, favoriteList.enabled)
        assertEquals(1, favoriteList.products.size)
        assertEquals("Product 1", favoriteList.products.first().title)
    }
}
