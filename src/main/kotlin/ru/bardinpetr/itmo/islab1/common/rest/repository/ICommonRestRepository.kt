package ru.bardinpetr.itmo.islab1.common.rest.repository

import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.ListPagingAndSortingRepository
import org.springframework.data.repository.history.RevisionRepository
import ru.bardinpetr.itmo.islab1.common.audit.model.RevisionIdType
import ru.bardinpetr.itmo.islab1.common.models.ICommonEntity
import ru.bardinpetr.itmo.islab1.common.models.IdType


/**
 * @param T object type
 */
interface ICommonRestRepository<T : ICommonEntity<IdType>> :
    CrudRepository<T, IdType>,
    ListPagingAndSortingRepository<T, IdType>,
    JpaSpecificationExecutor<T>,
    RevisionRepository<T, IdType, RevisionIdType>
