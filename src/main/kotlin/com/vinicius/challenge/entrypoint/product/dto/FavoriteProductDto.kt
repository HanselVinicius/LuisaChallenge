package com.vinicius.challenge.entrypoint.product.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class FavoriteProductDto(
    @field:NotNull
    val id: Long,
    @field:NotBlank
    val title: String,
    @field:NotBlank
    val description: String,
    @field:NotNull
    val price: BigDecimal,
    @field:NotBlank
    val image: String,
    @field:NotNull
    val clientId: Long
)
