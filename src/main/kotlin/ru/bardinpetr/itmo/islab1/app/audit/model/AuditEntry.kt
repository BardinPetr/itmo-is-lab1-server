package ru.bardinpetr.itmo.islab1.app.audit.model

import jakarta.persistence.*
import org.hibernate.envers.Audited
import jakarta.validation.constraints.PastOrPresent
import ru.bardinpetr.itmo.islab1.app.user.model.User
import java.time.LocalDateTime

@Entity
@Audited
@Table(name = "audit")
data class AuditEntry(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    var user: User,

    @field:PastOrPresent
    val date: LocalDateTime,

    @Enumerated(EnumType.STRING)
    var action: AuditActionType,



    var entityId: Long
)