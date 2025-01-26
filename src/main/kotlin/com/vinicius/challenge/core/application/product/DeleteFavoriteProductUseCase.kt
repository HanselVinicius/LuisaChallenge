package com.vinicius.challenge.core.application.product

import com.vinicius.challenge.core.application.product.gateway.DeleteFavoriteProductGateway
import com.vinicius.challenge.core.domain.client.service.GetClientByIdService
import com.vinicius.challenge.core.domain.product.service.DeleteFavoriteProductService

class DeleteFavoriteProductUseCase(
    private val getClientByIdService: GetClientByIdService,
    private val deleteFavoriteProductGateway: DeleteFavoriteProductGateway
) : DeleteFavoriteProductService {
    override fun deleteFavoriteProduct(clientId: Long, productId: Long) {
        val client = getClientByIdService.getClientById(clientId)
        val product = client.deleteProduct(productId)
        deleteFavoriteProductGateway.deleteFavoriteProduct(product)
    }
}
