package com.vinicius.challenge.core.application.client.factory

import com.vinicius.challenge.core.domain.auth.Auth
import com.vinicius.challenge.core.domain.client.Client

object ClientFactory {
    fun createClient(auth: Auth, name: String): Client {
        return Client(
            id = null,
            name = name,
            auth = auth,
            enabled = true
        )
    }
}
