package com.haythammones.kotlin.dsl.factory

import com.haythammones.kotlin.dsl.domain.Child
import com.haythammones.kotlin.dsl.domain.GrandChild
import com.haythammones.kotlin.dsl.utils.randomString
import java.util.*

class ChildFactory {
    var uuid: UUID = UUID.randomUUID()
    var name: String = randomString()
    var order: Int = 0
    private var grandChildren = mutableListOf<GrandChild>()
    var parent: UUID? = null

    fun grandChildren(block: GrandChildren.() -> Unit) = grandChildren.addAll(
        GrandChildren()
            .apply(block)
            .mapIndexed { index, grandChild -> grandChild.copy(parent = uuid, order = index + 1) },
    )

    fun build(): Child = Child(
        uuid = uuid,
        name = name,
        order = order,
        children = grandChildren,
        parent = parent,
    )
}

class GrandChildren : ArrayList<GrandChild>() {
    fun grandChild(block: GrandChildFactory.() -> Unit) = add(GrandChildFactory().apply(block).build())
}
