package com.github.juan1393.cleanArchitectureKotlin.ui.main.presenter

import com.github.juan1393.cleanArchitectureKotlin.app.navigator.Navigator
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.signOut.SignOutUseCase
import com.github.juan1393.cleanArchitectureKotlin.ui.base.Presenter
import com.github.juan1393.cleanArchitectureKotlin.ui.main.activity.MainView


class MainPresenter(override val view: MainView,
                    override val navigator: Navigator,
                    var signOutUseCase: SignOutUseCase)
    : Presenter<MainView> {

    fun signOut() {
        signOutUseCase.execute()
        navigator.toSplash()
    }

    override fun clearView() {
        TODO("not implemented")
    }
}