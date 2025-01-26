package com.vinicius.challenge.gateway.product.entity

import org.springframework.data.jpa.repository.JpaRepository

interface ProductEntityRepository : JpaRepository<ProductEntity, Long>
