package ru.bardinpetr.itmo.islab1.app.product.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import org.hibernate.envers.Audited
import org.hibernate.validator.constraints.Length
import ru.bardinpetr.itmo.islab1.app.organization.model.Organization
import ru.bardinpetr.itmo.islab1.app.person.model.Person
import ru.bardinpetr.itmo.islab1.app.person.model.UnitOfMeasure
import java.time.LocalDate

@Entity
@Audited
@Table(name = "product")
class Product(
    @field:NotBlank
    @field:NotNull
    var name: String,

    @field:NotNull
    @Embedded
    var coordinates: Coordinates,

    @field:NotNull
    var creationDate: LocalDate = LocalDate.now(),

    @Enumerated(EnumType.STRING)
    var unitOfMeasure: UnitOfMeasure? = null,

    @ManyToOne
    @JoinColumn(name = "manufacturer_id", referencedColumnName = "id")
    var manufacturer: Organization? = null,

    @field:Positive
    @field:NotNull
    var price: Float,

    @field:NotNull
    var manufactureCost: Double,

    @field:Positive
    @field:NotNull
    var rating: Long,

    @Column(name = "part_number", unique = true)
    @field:Length(min = 22)
    @field:NotNull
    var partNumber: String,

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    var owner: Person? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
)

