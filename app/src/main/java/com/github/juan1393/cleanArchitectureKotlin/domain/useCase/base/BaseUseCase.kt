package com.github.juan1393.cleanArchitectureKotlin.domain.useCase.base

import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.executor.MainThread
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.executor.UseCaseExecutor


abstract class BaseUseCase<R : BaseRequest, C : BaseResponse>(var executor: UseCaseExecutor,
                                                               var mainThread: MainThread) {

    var request: R? = null
    var response: C? = null

    fun execute(request: R? = null, response: C? = null) {
        this.request = request
        this.response = response

        val validated = request?.validate() ?: true
        if(validated) executor.run(this)
    }

    abstract fun run()

    protected fun notifyNetworkConnectionError() {
        mainThread.post(Runnable { response?.onNetworkConnectionError() })
    }

    protected fun notifyNetworkServiceError() {
        mainThread.post(Runnable { response?.onNetworkServiceError() })
    }

    protected fun notifyUnknownError() {
        mainThread.post(Runnable { response?.onUnknownError() })
    }
}

