package com.vinicius.challenge.entrypoint.product

import com.vinicius.challenge.core.domain.product.service.DeleteFavoriteProductService
import com.vinicius.challenge.core.domain.product.service.FavoriteProductService
import com.vinicius.challenge.entrypoint.product.dto.FavoriteProductDto
import com.vinicius.challenge.entrypoint.product.mapper.ProductControllerMapper
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/product")
@SecurityRequirement(name = "bearer-key")
class ProductController(
    private val favoriteProductService: FavoriteProductService,
    private val deleteFavoriteProductService: DeleteFavoriteProductService
) {

    @PostMapping
    fun favoriteProduct(
        @RequestBody @Valid
        favoriteProductDto: FavoriteProductDto
    ): ResponseEntity<Unit> {
        favoriteProductService.favoriteProduct(ProductControllerMapper.toDomainFomInsertProductDto(favoriteProductDto), favoriteProductDto.clientId)
        return ResponseEntity.ok().build()
    }

    @DeleteMapping("{clientId}/{productId}")
    fun deleteFavoriteProduct(@PathVariable clientId: Long, @PathVariable productId: Long): ResponseEntity<Unit> {
        deleteFavoriteProductService.deleteFavoriteProduct(clientId, productId)
        return ResponseEntity.noContent().build()
    }
}
