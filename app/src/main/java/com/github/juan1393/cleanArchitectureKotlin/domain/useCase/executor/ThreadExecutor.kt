package com.github.juan1393.cleanArchitectureKotlin.domain.useCase.executor

import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.base.BaseUseCase
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit


class ThreadExecutor : UseCaseExecutor {

    companion object {
        private val CORE_POOL_SIZE = 3
        private val MAX_POOL_SIZE = 5
        private val KEEP_ALIVE_TIME = 120
        private val TIME_UNIT = TimeUnit.SECONDS
        private val WORK_QUEUE = LinkedBlockingQueue<Runnable>()

        val threadPoolExecutor: ThreadPoolExecutor = ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME.toLong(),
                TIME_UNIT,
                WORK_QUEUE)
    }

    override fun run(baseUseCase: BaseUseCase<*, *>) {
        threadPoolExecutor.submit { baseUseCase.run() }
    }
}
