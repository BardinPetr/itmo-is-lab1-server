package ru.bardinpetr.itmo.islab1.common.rest.model

data class BaseResponse<T : Any>(
    val status: Boolean,
    val errors: List<String>,
    val data: T?
)

fun <T : Any> BaseResponse<T>.ok(data: T)
        = BaseResponse(true, emptyList(), data)

fun <T : Any> BaseResponse<T>.error(error: String)
        = BaseResponse(false, emptyList(), null)

