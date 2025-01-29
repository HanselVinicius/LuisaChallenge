package com.vinicius.challenge.gateway.client.entity

import com.vinicius.challenge.gateway.auth.entity.AuthEntity
import com.vinicius.challenge.gateway.client.favorite.entity.FavoriteListEntity
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import org.hibernate.annotations.SQLRestriction

@Entity(name = "client")
@Table(name = "client")
@SQLRestriction("enabled = true")
class ClientEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val name: String,
    @OneToOne
    val auth: AuthEntity,
    @OneToMany(mappedBy = "client", cascade = [CascadeType.ALL], orphanRemoval = true)
    val favoriteLists: MutableList<FavoriteListEntity> = mutableListOf(),
    val enabled: Boolean
)
