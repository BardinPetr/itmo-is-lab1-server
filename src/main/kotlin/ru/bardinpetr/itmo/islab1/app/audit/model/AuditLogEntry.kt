package ru.bardinpetr.itmo.islab1.app.audit.model

import org.hibernate.envers.RevisionType
import org.hibernate.envers.query.AuditQuery
import java.time.Instant

data class AuditLogEntry<T>(
    val timestamp: Instant,
    val author: Long,
    val revision: Long,
    val type: RevisionType,
    val state: T,
)


inline fun <reified T : Any> AuditQuery.typedResultList(): List<AuditLogEntry<T>> =
    resultList
        .map { it as Array<*> }
        .mapNotNull {
            val entry = (it[1] as? AuditRevisionEntry) ?: return@mapNotNull null
            AuditLogEntry(
                revision = entry.id!!,
                author = entry.userId,
                timestamp = entry.timestamp,
                type = (it[2] as? RevisionType) ?: return@mapNotNull null,
                state = (it[0] as? T) ?: return@mapNotNull null,
            )
        }
