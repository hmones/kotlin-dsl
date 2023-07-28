package com.haythammones.kotlin.dsl.domain

import java.util.UUID

data class Child(
    val uuid: UUID,
    val name: String,
    val order: Int,
    val children: List<GrandChild> = listOf(),
    val parent: UUID? = null,
)
