package com.github.juan1393.cleanArchitectureKotlin.data.mapper

import com.github.juan1393.cleanArchitectureKotlin.data.exception.MapperException


internal interface Mapper<in I, out O> {

    @Throws(MapperException::class)
    fun map(input: I): O
}
