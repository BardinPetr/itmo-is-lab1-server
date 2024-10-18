package ru.bardinpetr.itmo.islab1.app.product.model

import jakarta.persistence.Embeddable

@Embeddable
class Coordinates(
    var x: Float,
    var y: Int
)