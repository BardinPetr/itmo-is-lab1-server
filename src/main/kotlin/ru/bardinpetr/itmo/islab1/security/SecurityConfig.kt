package ru.bardinpetr.itmo.islab1.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(
    prePostEnabled = true,
    securedEnabled = true,
    jsr250Enabled = true
)
class SecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .sessionManagement {
                it.disable()
            }
            .cors(Customizer.withDefaults())
            .csrf {
                it.disable()
            }
            .authorizeHttpRequests {
                it
                    .requestMatchers(
                        AntPathRequestMatcher("/docs*"),
                        AntPathRequestMatcher("/docs/*"),
                        AntPathRequestMatcher("/swagger-ui/*")
                    ).permitAll()
                    .anyRequest().permitAll() //.authenticated()
            }
            .build()
    }

    @Bean
    fun corsConfigurer(): WebMvcConfigurer {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(registry: CorsRegistry) {
                registry
                    .addMapping("/**")
                    .allowedOriginPatterns("*")
                    .allowedOrigins("*")
                    .allowedMethods("*")
            }
        }
    }
}