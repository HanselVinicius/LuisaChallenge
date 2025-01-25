package com.vinicius.challenge.core.domain.client

import com.vinicius.challenge.core.domain.auth.Auth

class Client(
    val id: Long?,
    val name: String,
    val auth: Auth,
    var favoriteList: FavoriteList? = null,
    var enabled: Boolean
) {
    fun insertFavoriteList(favoriteList: FavoriteList) {
        if (this.favoriteList != null) {
            throw IllegalArgumentException("Client already has one favorite list")
        }
        this.favoriteList = favoriteList
    }

    fun editFavoriteList(favoriteList: FavoriteList) {
        if (this.favoriteList == null) {
            throw IllegalArgumentException("Client does not have a favorite list")
        }
        favoriteList.client = this
        this.favoriteList!!.editFavoriteList(favoriteList)
    }

    fun deleteFavoriteList() {
        if (this.favoriteList == null) {
            throw IllegalArgumentException("Client does not have a favorite list")
        }
        this.favoriteList!!.client = this
        this.favoriteList!!.deleteFavoriteList()
    }
}
