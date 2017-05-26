package com.github.juan1393.cleanArchitectureKotlin.ui.splash.presenter

import com.github.juan1393.cleanArchitectureKotlin.app.navigator.Navigator
import com.github.juan1393.cleanArchitectureKotlin.domain.model.User
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.getCurrentUser.GetCurrentUserResponse
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.getCurrentUser.GetCurrentUserUseCase
import com.github.juan1393.cleanArchitectureKotlin.ui.base.Presenter
import com.github.juan1393.cleanArchitectureKotlin.ui.splash.activity.SplashView
import java.util.*
import kotlin.concurrent.schedule


class SplashPresenter(override val view: SplashView,
                      override val navigator: Navigator,
                      val getCurrentUserUseCase: GetCurrentUserUseCase) :
        Presenter<SplashView>(), GetCurrentUserResponse {

    private val COUNT_DOWN_TIME: Long = 2000

    fun loadInitialData() = Timer("SettingUp", false).schedule(COUNT_DOWN_TIME) {
        getCurrentUserUseCase.execute(response = this@SplashPresenter)
    }

    override fun onCurrentUserReceived(user: User) {
        navigator.toMain()
    }

    override fun clearView() {}
}