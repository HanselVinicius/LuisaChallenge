package com.vinicius.challenge.entrypoint.favorite

import com.vinicius.challenge.core.domain.client.factory.FavoriteListFactory
import com.vinicius.challenge.core.domain.client.service.favorite.DeleteFavoriteListService
import com.vinicius.challenge.core.domain.client.service.favorite.EditFavoriteListService
import com.vinicius.challenge.core.domain.client.service.favorite.GetFavoriteListByClientService
import com.vinicius.challenge.core.domain.client.service.favorite.InsertFavoriteListService
import com.vinicius.challenge.entrypoint.favorite.dto.EditFavoriteListDto
import com.vinicius.challenge.entrypoint.favorite.dto.FavoriteListReturnDto
import com.vinicius.challenge.entrypoint.favorite.dto.InsertFavoriteListDto
import com.vinicius.challenge.entrypoint.favorite.mapper.FavoriteListControllerMapper
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/v1/favorite-list")
@SecurityRequirement(name = "bearer-key")
class FavoriteListController(
    private val insertFavoriteListService: InsertFavoriteListService,
    private val getFavoriteListByClientService: GetFavoriteListByClientService,
    private val editFavoriteListService: EditFavoriteListService,
    private val deleteFavoriteListService: DeleteFavoriteListService
) {

    @PostMapping
    fun insertFavoriteList(
        @RequestBody @Valid
        insertFavoriteListDto: InsertFavoriteListDto
    ): ResponseEntity<Unit> {
        val favoriteList = FavoriteListFactory.createFavoriteList(
            products = emptySet(),
            name = insertFavoriteListDto.name,
            description = insertFavoriteListDto.description
        )
        insertFavoriteListService.insertFavoriteList(insertFavoriteListDto.clientId, favoriteList)
        val locationUri = UriComponentsBuilder
            .fromPath("/v1/favorite-list/{clientId}")
            .buildAndExpand(insertFavoriteListDto.clientId)
            .toUri()

        return ResponseEntity.created(locationUri).build()
    }

    @GetMapping("/{clientId}")
    fun getFavoriteListByClient(@PathVariable clientId: Long): ResponseEntity<FavoriteListReturnDto> {
        val favoriteList =
            getFavoriteListByClientService.getFavoriteListByClient(clientId) ?: return ResponseEntity.notFound().build()

        return ResponseEntity.ok(FavoriteListControllerMapper.fromFavoriteList(favoriteList))
    }

    @PutMapping("/{clientId}")
    fun editFavoriteListByClient(
        @PathVariable clientId: Long,
        @RequestBody @Valid
        editFavoriteListDto: EditFavoriteListDto
    ): ResponseEntity<Unit> {
        val favoriteList = FavoriteListFactory.createFavoriteList(
            products = emptySet(),
            name = editFavoriteListDto.name,
            description = editFavoriteListDto.description
        )
        editFavoriteListService.editFavoriteListByClient(clientId, favoriteList)
        val locationUri = UriComponentsBuilder
            .fromPath("/v1/favorite-list/{clientId}")
            .buildAndExpand(clientId)
            .toUri()

        return ResponseEntity.ok().location(locationUri).build()
    }

    @DeleteMapping("/{clientId}")
    fun deleteFavoriteListByClient(@PathVariable clientId: Long): ResponseEntity<Unit> {
        deleteFavoriteListService.deleteFavoriteList(clientId)
        return ResponseEntity.noContent().build()
    }
}
