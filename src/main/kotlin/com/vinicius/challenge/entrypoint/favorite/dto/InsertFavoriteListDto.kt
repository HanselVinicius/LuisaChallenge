package com.vinicius.challenge.entrypoint.favorite.dto

import jakarta.validation.constraints.NotBlank
import org.jetbrains.annotations.NotNull

data class InsertFavoriteListDto(
    @field:NotNull
    val clientId: Long,
    @field:NotBlank
    val name: String,
    @field:NotBlank
    val description: String
)
