package com.vinicius.challenge.core.domain.product

import com.vinicius.challenge.core.domain.client.FavoriteList
import java.math.BigDecimal

class Product(
    val id: Long,
    val title: String,
    val price: BigDecimal,
    val description: String,
    val image: String,
    var enabled: Boolean,
    var favoriteList: FavoriteList? = null
)
