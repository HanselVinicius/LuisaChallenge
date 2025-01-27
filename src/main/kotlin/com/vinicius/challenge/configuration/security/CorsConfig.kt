package com.vinicius.challenge.configuration.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

@Configuration
class CorsConfig {
    @Bean
    fun corsFilter(): CorsFilter {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()
        config.allowCredentials = true
        config.addAllowedOriginPattern("*")
        config.addAllowedHeader("*")
        config.allowedHeaders = listOf("*")
        config.setAllowedOriginPatterns(listOf("*"))
        config.allowedMethods =
            mutableListOf("GET", "POST", "DELETE", "PUT", "PATCH", "OPTIONS")

        source.registerCorsConfiguration("/**", config)
        return CorsFilter(source)
    }
}
