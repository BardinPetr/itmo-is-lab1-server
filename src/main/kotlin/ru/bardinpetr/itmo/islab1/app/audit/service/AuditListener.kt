package ru.bardinpetr.itmo.islab1.app.audit.service

import org.hibernate.envers.RevisionListener
import ru.bardinpetr.itmo.islab1.app.audit.model.AuditRevisionEntry


class AuditListener : RevisionListener {
    override fun newRevision(revisionEntity: Any) {
        val entity = revisionEntity as AuditRevisionEntry
        entity.userId = 234234 //TODO: fill from session
    }
}