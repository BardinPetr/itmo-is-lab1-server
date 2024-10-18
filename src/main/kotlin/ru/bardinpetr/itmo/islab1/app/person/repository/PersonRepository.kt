package ru.bardinpetr.itmo.islab1.app.person.repository

import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.ListPagingAndSortingRepository
import org.springframework.data.repository.history.RevisionRepository
import ru.bardinpetr.itmo.islab1.app.person.model.Person

interface PersonRepository : CrudRepository<Person, Long>, ListPagingAndSortingRepository<Person, Long>,
    JpaSpecificationExecutor<Person>