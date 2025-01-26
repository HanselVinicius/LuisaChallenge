package com.vinicius.challenge.entrypoint.favorite.dto

data class ProductReturnDto(
    val id: Long,
    val name: String,
    val description: String,
    val price: Double,
    val image: String
)
