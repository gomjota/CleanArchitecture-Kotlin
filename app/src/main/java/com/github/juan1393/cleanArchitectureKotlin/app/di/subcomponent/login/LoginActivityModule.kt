package com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.login

import com.github.juan1393.cleanArchitectureKotlin.app.di.module.ActivityModule
import com.github.juan1393.cleanArchitectureKotlin.app.di.scope.ActivityScope
import com.github.juan1393.cleanArchitectureKotlin.app.navigator.Navigator
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.login.LoginUseCase
import com.github.juan1393.cleanArchitectureKotlin.ui.login.activity.LoginActivity
import com.github.juan1393.cleanArchitectureKotlin.ui.login.activity.LoginView
import com.github.juan1393.cleanArchitectureKotlin.ui.login.presenter.LoginPresenter
import dagger.Module
import dagger.Provides


@Module
class LoginActivityModule(activity: LoginActivity) : ActivityModule(activity) {

    @Provides @ActivityScope
    fun provideLoginView(): LoginView = activity as LoginView

    @Provides @ActivityScope
    fun provideLoginPresenter(view: LoginView, navigator: Navigator, loginUseCase: LoginUseCase)
            = LoginPresenter(view, navigator, loginUseCase)
}