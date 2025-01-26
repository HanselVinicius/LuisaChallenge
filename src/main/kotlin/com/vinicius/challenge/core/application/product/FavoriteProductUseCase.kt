package com.vinicius.challenge.core.application.product

import com.vinicius.challenge.core.application.product.gateway.FavoriteProductGateway
import com.vinicius.challenge.core.domain.client.service.GetClientByIdService
import com.vinicius.challenge.core.domain.client.service.SendNotificationService
import com.vinicius.challenge.core.domain.product.Product
import com.vinicius.challenge.core.domain.product.service.FavoriteProductService

class FavoriteProductUseCase(
    private val getClientByIdUseCase: GetClientByIdService,
    private val favoriteProductGateway: FavoriteProductGateway,
    private val sendNotificationService: SendNotificationService
) : FavoriteProductService {
    override fun favoriteProduct(product: Product, clientId: Long) {
        val client = getClientByIdUseCase.getClientById(clientId)
        client.addFavoriteProduct(product)
        favoriteProductGateway.favoriteProduct(product, client)
        sendNotificationService.sendNotification(client, "Product ${product.title} added to favorites")
    }
}
