package com.vinicius.challenge.gateway.product

import com.vinicius.challenge.core.application.product.gateway.FavoriteProductGateway
import com.vinicius.challenge.core.domain.client.Client
import com.vinicius.challenge.core.domain.product.Product
import com.vinicius.challenge.gateway.product.entity.ProductEntityMapper
import com.vinicius.challenge.gateway.product.entity.ProductEntityRepository
import org.springframework.stereotype.Component

@Component
class FavoriteProductGatewayImpl(
    private val productEntityRepository: ProductEntityRepository
) : FavoriteProductGateway {
    override fun favoriteProduct(product: Product, client: Client) {
        val productEntity = ProductEntityMapper.toEntity(product)
        this.productEntityRepository.save(productEntity)
    }
}
