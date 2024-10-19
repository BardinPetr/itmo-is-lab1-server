package ru.bardinpetr.itmo.islab1.app.product.repository

import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.ListPagingAndSortingRepository
import org.springframework.data.repository.history.RevisionRepository
import ru.bardinpetr.itmo.islab1.common.rest.repository.ICommonRestRepository
import ru.bardinpetr.itmo.islab1.app.product.model.Product

interface ProductRepository : ICommonRestRepository<Product>
