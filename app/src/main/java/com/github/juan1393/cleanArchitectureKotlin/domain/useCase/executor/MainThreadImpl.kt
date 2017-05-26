package com.github.juan1393.cleanArchitectureKotlin.domain.useCase.executor

import android.os.Handler
import android.os.Looper
import javax.inject.Inject


class MainThreadImpl : MainThread {

    var handler: Handler = Handler(Looper.getMainLooper())

    override fun post(runnable: Runnable) {
        handler.post(runnable)
    }
}
