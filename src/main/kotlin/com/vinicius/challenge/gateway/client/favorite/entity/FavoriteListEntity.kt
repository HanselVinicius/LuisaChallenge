package com.vinicius.challenge.gateway.client.favorite.entity

import com.vinicius.challenge.gateway.client.entity.ClientEntity
import com.vinicius.challenge.gateway.product.entity.ProductEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import org.hibernate.annotations.SQLRestriction

@Entity(name = "favorite_list")
@Table(name = "favorite_list")
@SQLRestriction("enabled = true")
class FavoriteListEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val name: String,
    val description: String,
    @OneToMany(mappedBy = "favoriteListEntity")
    val products: Set<ProductEntity> = HashSet(),
    @ManyToOne
    @JoinColumn(name = "client_id")
    var client: ClientEntity? = null,
    val enabled: Boolean
)
