package com.github.juan1393.cleanArchitectureKotlin.ui.base

import com.github.juan1393.cleanArchitectureKotlin.app.navigator.Navigator
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.base.BaseResponse

abstract class Presenter<out T : PresentationView> :
        BaseResponse {

    abstract val view: T
    abstract val navigator: Navigator

    abstract fun clearView()

    override fun onNetworkConnectionError() {
        clearView()
    }

    override fun onNetworkServiceError() {
        clearView()
    }

    override fun onUnknownError() {
        clearView()
    }

    override fun onUserIsNotLoggedIn() {
        navigator.toLogin()
    }
}