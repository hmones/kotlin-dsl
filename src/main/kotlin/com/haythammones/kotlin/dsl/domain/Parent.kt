package com.haythammones.kotlin.dsl.domain

import com.haythammones.kotlin.dsl.domain.values.Job
import java.util.*

data class Parent(
    val uuid: UUID,
    val name: String? = null,
    val job: Job,
    val children: List<Child> = listOf(),
)
