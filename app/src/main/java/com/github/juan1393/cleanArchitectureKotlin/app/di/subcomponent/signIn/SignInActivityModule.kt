package com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.signIn

import com.github.juan1393.cleanArchitectureKotlin.app.di.module.ActivityModule
import com.github.juan1393.cleanArchitectureKotlin.app.di.scope.ActivityScope
import com.github.juan1393.cleanArchitectureKotlin.app.navigator.Navigator
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.signIn.SignInUseCase
import com.github.juan1393.cleanArchitectureKotlin.ui.signIn.activity.SignInActivity
import com.github.juan1393.cleanArchitectureKotlin.ui.signIn.activity.SignInView
import com.github.juan1393.cleanArchitectureKotlin.ui.signIn.presenter.SignInPresenter
import dagger.Module
import dagger.Provides


@Module
class SignInActivityModule(activity: SignInActivity) : ActivityModule(activity) {

    @Provides @ActivityScope
    fun provideSignInView(): SignInView = activity as SignInView

    @Provides @ActivityScope
    fun provideSignInPresenter(view: SignInView, navigator: Navigator, signInUseCase: SignInUseCase)
            = SignInPresenter(view, navigator, signInUseCase)
}