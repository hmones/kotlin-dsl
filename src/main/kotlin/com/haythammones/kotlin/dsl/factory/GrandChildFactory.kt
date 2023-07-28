package com.haythammones.kotlin.dsl.factory

import com.haythammones.kotlin.dsl.domain.GrandChild
import com.haythammones.kotlin.dsl.utils.randomString
import java.util.*

class GrandChildFactory {
    var uuid: UUID = UUID.randomUUID()
    var name: String = randomString()
    var order: Int = 0
    var parent: UUID? = null

    fun build(): GrandChild = GrandChild(
        uuid = uuid,
        name = name,
        order = order,
        parent = parent,
    )
}
