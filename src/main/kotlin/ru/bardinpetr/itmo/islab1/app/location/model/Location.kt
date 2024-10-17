package ru.bardinpetr.itmo.islab1.app.location.model

import jakarta.persistence.*
import org.hibernate.envers.Audited
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import ru.bardinpetr.itmo.islab1.app.user.model.User

@Entity
@Audited
@Table(name = "location")
data class Location(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    var x: Long,

    var y: Int,

    var z: Long,

    @field:NotBlank
    @field:NotNull
    var name: String,
)
