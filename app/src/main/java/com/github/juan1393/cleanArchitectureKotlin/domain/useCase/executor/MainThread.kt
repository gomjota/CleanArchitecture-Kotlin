package com.github.juan1393.cleanArchitectureKotlin.domain.useCase.executor

interface MainThread {
    fun post(runnable: Runnable)
}
