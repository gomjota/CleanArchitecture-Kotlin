package com.github.juan1393.cleanArchitectureKotlin.domain.useCase.executor

import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.base.BaseUseCase


interface UseCaseExecutor {
    fun run(baseUseCase: BaseUseCase<*, *>)
}