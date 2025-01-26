package com.vinicius.challenge.gateway.product

import com.vinicius.challenge.core.application.product.gateway.DeleteFavoriteProductGateway
import com.vinicius.challenge.core.domain.product.Product
import com.vinicius.challenge.gateway.product.entity.ProductEntityMapper
import com.vinicius.challenge.gateway.product.entity.ProductEntityRepository
import org.springframework.stereotype.Component

@Component
class DeleteFavoriteProductGatewayImpl(private val productEntityRepository: ProductEntityRepository) : DeleteFavoriteProductGateway {
    override fun deleteFavoriteProduct(product: Product) {
        val productEntity = ProductEntityMapper.toEntity(product)
        productEntityRepository.save(productEntity)
    }
}
