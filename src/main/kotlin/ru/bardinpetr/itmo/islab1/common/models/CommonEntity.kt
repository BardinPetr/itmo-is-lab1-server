package ru.bardinpetr.itmo.islab1.common.models


/**
 * @param K ID type
 */
interface ICommonEntity<K> {
    var id: K?
}

typealias IdType = Long
typealias IDefaultCommonEntity = ICommonEntity<IdType>