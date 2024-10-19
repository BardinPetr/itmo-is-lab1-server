package ru.bardinpetr.itmo.islab1.common.audit.service

import org.hibernate.envers.AuditReader
import org.hibernate.envers.query.AuditEntity
import org.hibernate.envers.query.AuditQuery
import org.springframework.stereotype.Service
import ru.bardinpetr.itmo.islab1.common.audit.model.AuditLogEntry
import ru.bardinpetr.itmo.islab1.common.audit.model.typedResultList
import kotlin.reflect.KClass

@Service
class AuditService<T : Any>(
    private val auditReader: AuditReader
) {
    fun queryByType(clazz: KClass<T>): AuditQuery =
        auditReader
            .createQuery()
            .forRevisionsOfEntity(clazz.java, false, true)
}

/**
 * Returns audit log for all objects of type T
 */
inline fun <reified T : Any> AuditService<T>.getAuditLog(): List<AuditLogEntry<T>> =
    queryByType(T::class)
        .typedResultList<T>()

/**
 * Returns audit log for item ot type T with specified id
 */
inline fun <reified T : Any> AuditService<T>.getEntityAuditLog(id: Long): AuditLogEntry<T>? =
    queryByType(T::class)
        .add(AuditEntity.id().eq(id))
        .typedResultList<T>()
        .firstOrNull()
