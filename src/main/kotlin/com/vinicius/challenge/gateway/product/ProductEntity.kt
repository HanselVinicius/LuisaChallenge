package com.vinicius.challenge.gateway.product

import com.vinicius.challenge.gateway.client.favorite.entity.FavoriteListEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.hibernate.annotations.SQLRestriction
import java.math.BigDecimal
@Entity(name = "product")
@Table(name = "product")
@SQLRestriction("enabled = true")
class ProductEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val title: String,
    val price: BigDecimal,
    val description: String,
    val image: String,
    @ManyToOne
    @JoinColumn(name = "favorite_list_id")
    private val favoriteListEntity: FavoriteListEntity?,
    val enabled: Boolean
)
