package com.vinicius.challenge.entrypoint.favorite.dto

data class FavoriteListReturnDto(
    val id: Long,
    val name: String,
    val description: String,
    val products: Set<ProductReturnDto>
)
