package ru.bardinpetr.itmo.islab1.app.location.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import org.hibernate.envers.Audited
import ru.bardinpetr.itmo.islab1.common.models.ICommonEntity

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
    override var id: Long? = null
) : ICommonEntity<Long>
