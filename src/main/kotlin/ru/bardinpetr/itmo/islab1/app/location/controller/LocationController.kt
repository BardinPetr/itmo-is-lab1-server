package ru.bardinpetr.itmo.islab1.app.location.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.bardinpetr.itmo.islab1.common.rest.controller.AbstractCommonRestController
import ru.bardinpetr.itmo.islab1.app.location.model.Location

@RequestMapping("/api/location")
@RestController
class LocationController : AbstractCommonRestController<Location>(Location::class)
