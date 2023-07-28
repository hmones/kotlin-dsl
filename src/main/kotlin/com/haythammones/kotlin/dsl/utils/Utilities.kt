package com.haythammones.kotlin.dsl.utils

import org.apache.commons.lang3.RandomStringUtils

fun randomString(length: Int = 10): String = RandomStringUtils.randomAlphabetic(length)
