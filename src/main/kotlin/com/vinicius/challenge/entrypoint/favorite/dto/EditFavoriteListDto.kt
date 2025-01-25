package com.vinicius.challenge.entrypoint.favorite.dto

import jakarta.validation.constraints.NotBlank

data class EditFavoriteListDto(
    @field:NotBlank
    val name: String,
    @field:NotBlank
    val description: String
)
