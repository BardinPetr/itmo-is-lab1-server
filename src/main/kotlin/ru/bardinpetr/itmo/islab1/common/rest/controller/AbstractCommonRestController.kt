package ru.bardinpetr.itmo.islab1.common.rest.controller

import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.bardinpetr.itmo.islab1.common.models.IDefaultCommonEntity
import ru.bardinpetr.itmo.islab1.common.rest.repository.ICommonRestRepository
import kotlin.reflect.KClass

@Validated
@RestController
abstract class AbstractCommonRestController<T : IDefaultCommonEntity>(
    private val clazz: KClass<T>
) {

    @Autowired
    private lateinit var repository: ICommonRestRepository<T>

    @GetMapping
    fun all(pageable: Pageable): Page<T> {
        return repository.findAll(pageable)
    }

    @PostMapping
    fun create(@Valid @RequestBody entity: T): ResponseEntity<T> {
        return ResponseEntity.ok(repository.save(entity))
    }
}
