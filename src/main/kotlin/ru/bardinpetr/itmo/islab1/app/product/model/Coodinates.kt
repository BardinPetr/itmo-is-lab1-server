package ru.bardinpetr.itmo.islab1.app.product.model

import jakarta.persistence.Embeddable

@Embeddable
data class Coordinates(
    var x: Float,
    var y: Int
)