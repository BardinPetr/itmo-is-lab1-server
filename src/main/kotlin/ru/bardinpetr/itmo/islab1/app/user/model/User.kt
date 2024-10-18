package ru.bardinpetr.itmo.islab1.app.user.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import org.hibernate.envers.Audited

@Entity
@Audited
@Table(name = "user")
class User(
    @field:NotBlank
    var username: String,

    @field:NotBlank
    var passwordHash: String,

    @Enumerated(EnumType.STRING)
    var role: UserRole,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
)