package com.vinicius.challenge.entrypoint.auth

import com.vinicius.challenge.core.domain.auth.service.InsertAuthService
import com.vinicius.challenge.core.domain.auth.service.LoginAuthService
import com.vinicius.challenge.core.domain.client.factory.ClientFactory
import com.vinicius.challenge.core.domain.client.service.InsertClientService
import com.vinicius.challenge.entrypoint.auth.dto.AuthDto
import com.vinicius.challenge.entrypoint.auth.dto.RegisterDto
import com.vinicius.challenge.entrypoint.auth.dto.TokenDto
import com.vinicius.challenge.entrypoint.auth.mapper.AuthControllerMapper
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/auth")
class AuthController(
    private val insertAuthService: InsertAuthService,
    private val loginAuthService: LoginAuthService,
    private val insertClientService: InsertClientService
) {

    @PostMapping("/register")
    fun insertClient(
        @Valid @RequestBody
        registerDto: RegisterDto
    ): ResponseEntity<TokenDto> {
        val auth = AuthControllerMapper.toDomain(registerDto)
        val client = ClientFactory.createClient(auth, registerDto.name)
        val authInserted = insertAuthService.insertAuth(auth)
        client.auth.id = authInserted.id
        insertClientService.insertClient(client)
        val token = loginAuthService.login(registerDto.principal, registerDto.credentials)
        return ResponseEntity.ok(TokenDto(token.token, token.client.name, null, token.client.id!!))
    }

    @PostMapping("/authenticate")
    fun login(
        @Valid @RequestBody
        authDto: AuthDto
    ): ResponseEntity<TokenDto> {
        val auth = AuthControllerMapper.toDomain(authDto)
        val token = loginAuthService.login(auth.principal, auth.credentials)
        token.client.favoriteList ?: return ResponseEntity.ok(TokenDto(token.token, token.client.name, null, token.client.id!!))
        return ResponseEntity.ok(TokenDto(token.token, token.client.name, token.client.favoriteList!!.id, token.client.id!!))
    }
}
