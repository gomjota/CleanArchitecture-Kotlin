package com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.recoverPassword

import com.github.juan1393.cleanArchitectureKotlin.app.di.module.ActivityModule
import com.github.juan1393.cleanArchitectureKotlin.app.di.scope.ActivityScope
import com.github.juan1393.cleanArchitectureKotlin.app.navigator.Navigator
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.recoverPassword.RecoverPasswordUseCase
import com.github.juan1393.cleanArchitectureKotlin.app.ui.recoverPassword.activity.RecoverPasswordActivity
import com.github.juan1393.cleanArchitectureKotlin.app.ui.recoverPassword.activity.RecoverPasswordView
import com.github.juan1393.cleanArchitectureKotlin.app.ui.recoverPassword.presenter.RecoverPasswordPresenter
import dagger.Module
import dagger.Provides


@Module
class RecoverPasswordActivityModule(activity: RecoverPasswordActivity) : ActivityModule(activity) {

    @Provides @ActivityScope
    fun provideRecoverPasswordView(): RecoverPasswordView = activity as RecoverPasswordView

    @Provides @ActivityScope
    fun provideRecoverPasswordPresenter(view: RecoverPasswordView,
                                        navigator: Navigator,
                                        recoverPasswordUseCase: RecoverPasswordUseCase)
            = RecoverPasswordPresenter(view, navigator, recoverPasswordUseCase)
}