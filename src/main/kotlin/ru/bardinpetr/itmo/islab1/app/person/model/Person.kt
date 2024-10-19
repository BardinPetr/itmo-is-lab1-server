package ru.bardinpetr.itmo.islab1.app.person.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import org.hibernate.envers.Audited
import ru.bardinpetr.itmo.islab1.common.models.ICommonEntity
import ru.bardinpetr.itmo.islab1.app.location.model.Location

@Entity
@Audited
@Table(name = "person")
class Person(
    @Column(nullable = false)
    @field:NotBlank
    @field:NotNull
    var name: String,

    @Enumerated(EnumType.STRING)
    @field:NotNull
    var eyeColor: Color,

    @Enumerated(EnumType.STRING)
    var hairColor: Color? = null,

    @OneToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    var location: Location? = null,

    @field:Positive
    @field:NotNull
    var height: Double,

    @Enumerated(EnumType.STRING)
    var nationality: Country? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override var id: Long? = null
) : ICommonEntity<Long>

