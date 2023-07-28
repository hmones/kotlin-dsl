package com.haythammones.kotlin.dsl.factory

import com.haythammones.kotlin.dsl.domain.Child
import com.haythammones.kotlin.dsl.domain.Parent
import com.haythammones.kotlin.dsl.domain.values.Job
import com.haythammones.kotlin.dsl.utils.randomString
import java.util.UUID

@DslMarker
annotation class ParentDSL

@ParentDSL
class ParentFactory {
    var uuid: UUID = UUID.randomUUID()
    var name: String = randomString()
    var job: Job = Job.values().random()
    private var children = mutableListOf<Child>()

    fun children(block: Children.() -> Unit) = children.addAll(
        Children()
            .apply(block)
            .mapIndexed { index, child -> child.copy(parent = uuid, order = index + 1) },
    )

    fun build(): Parent = Parent(
        uuid = uuid,
        name = name,
        job = job,
        children = children,
    )
}

fun parent(block: ParentFactory.() -> Unit): Parent = ParentFactory().apply(block).build()

class Children : ArrayList<Child>() {
    fun child(block: ChildFactory.() -> Unit) = add(ChildFactory().apply(block).build())
}
