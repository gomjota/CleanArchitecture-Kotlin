package com.github.juan1393.cleanArchitectureKotlin.domain.useCase.base

abstract class BaseRequest {

    abstract fun validate(): Boolean
}
