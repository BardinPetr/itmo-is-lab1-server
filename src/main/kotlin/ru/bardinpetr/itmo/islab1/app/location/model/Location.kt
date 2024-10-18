package ru.bardinpetr.itmo.islab1.app.location.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import org.hibernate.envers.Audited

@Entity
@Audited
@Table(name = "location")
class Location(
    var x: Long,

    var y: Int,

    var z: Long,

    @field:NotBlank
    @field:NotNull
    var name: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
)
