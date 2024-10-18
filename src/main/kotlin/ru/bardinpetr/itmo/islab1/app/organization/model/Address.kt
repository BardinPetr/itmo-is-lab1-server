package ru.bardinpetr.itmo.islab1.app.organization.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import org.hibernate.envers.Audited
import ru.bardinpetr.itmo.islab1.app.location.model.Location

@Entity
@Audited
@Table(name = "address")
class Address(
    @field:NotBlank
    @field:NotNull
    var street: String,

    @ManyToOne
    @JoinColumn(name = "town_id", referencedColumnName = "id")
    @field:NotNull
    var town: Location,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
)