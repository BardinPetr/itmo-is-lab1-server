package ru.bardinpetr.itmo.islab1.app.location.repository

import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.ListPagingAndSortingRepository
import org.springframework.data.repository.history.RevisionRepository
import ru.bardinpetr.itmo.islab1.app.location.model.Location

interface LocationRepository :
    CrudRepository<Location, Long>,
    ListPagingAndSortingRepository<Location, Long>,
    JpaSpecificationExecutor<Location>,
    RevisionRepository<Location, Long, Long> {

}