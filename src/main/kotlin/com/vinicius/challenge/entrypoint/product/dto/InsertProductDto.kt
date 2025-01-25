package com.vinicius.challenge.entrypoint.product.dto

import jakarta.validation.constraints.NotBlank
import java.math.BigDecimal

data class InsertProductDto(
    @field:NotBlank
    val id: Long,
    @field:NotBlank
    val title: String,
    @field:NotBlank
    val description: String,
    @field:NotBlank
    val price: BigDecimal,
    @field:NotBlank
    val image: String
)
