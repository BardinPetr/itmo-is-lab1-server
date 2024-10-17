package ru.bardinpetr.itmo.islab1.app.user.model

import jakarta.persistence.*
import org.hibernate.envers.Audited
import jakarta.validation.constraints.NotBlank

@Entity
@Audited
@Table(name = "user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @field:NotBlank
    var username: String,

    @field:NotBlank
    var passwordHash: String,

    @Enumerated(EnumType.STRING)
    var role: UserRole
)