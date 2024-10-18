package ru.bardinpetr.itmo.islab1.app.person.model

import ru.bardinpetr.itmo.islab1.app.location.model.Location
import jakarta.persistence.*
import org.hibernate.envers.Audited
import jakarta.validation.constraints.*

@Entity
@Audited
@Table(name = "person")
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

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
    var nationality: Country? = null
)

