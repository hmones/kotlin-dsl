package com.haythammones.kotlin.dsl.domain

import java.util.*

data class GrandChild(
    val uuid: UUID = UUID.randomUUID(),
    val name: String,
    val order: Int,
    val parent: UUID? = null,
)
