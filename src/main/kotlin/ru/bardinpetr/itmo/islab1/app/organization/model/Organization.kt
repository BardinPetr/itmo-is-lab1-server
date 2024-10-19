package ru.bardinpetr.itmo.islab1.app.organization.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.PositiveOrZero
import org.hibernate.envers.Audited
import org.hibernate.validator.constraints.Length
import ru.bardinpetr.itmo.islab1.common.models.ICommonEntity

@Entity
@Audited
@Table(name = "organizations")
class Organization(
    @field:NotBlank
    @field:NotNull
    var name: String,

    @ManyToOne
    @JoinColumn(name = "official_address_id", referencedColumnName = "id")
    var officialAddress: Address? = null,

    @field:PositiveOrZero
    var annualTurnover: Float? = null,

    @field:Positive
    var employeesCount: Long,

    @Column(name = "full_name", unique = true)
    @field:NotBlank
    @field:Length(max = 715)
    var fullName: String,

    @Enumerated(EnumType.STRING)
    var type: OrganizationType? = null,

    @OneToOne
    @JoinColumn(name = "postal_address_id", referencedColumnName = "id")
    var postalAddress: Address? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override var id: Long? = null
) : ICommonEntity<Long>
