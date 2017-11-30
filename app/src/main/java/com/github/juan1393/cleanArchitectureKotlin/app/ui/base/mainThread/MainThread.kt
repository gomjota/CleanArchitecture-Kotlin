package com.github.juan1393.cleanArchitectureKotlin.app.ui.base.mainThread

interface MainThread {
    fun post(runnable: Runnable)
}
