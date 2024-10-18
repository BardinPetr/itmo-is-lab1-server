package ru.bardinpetr.itmo.islab1.app.audit.model

import jakarta.persistence.*
import org.hibernate.envers.RevisionEntity
import org.hibernate.envers.RevisionNumber
import org.hibernate.envers.RevisionTimestamp
import ru.bardinpetr.itmo.islab1.app.audit.service.AuditListener
import java.time.Instant


@Entity
@RevisionEntity(AuditListener::class)
@Table(name = "rev_info")
class AuditRevisionEntry(
    @Temporal(TemporalType.TIMESTAMP)
    @RevisionTimestamp
    @Column(nullable = false)
    var timestamp: Instant,

    @Column(nullable = false)
    var userId: Long,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @RevisionNumber
    var id: Long? = null
)