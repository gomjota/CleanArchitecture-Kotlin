package com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.signUp

import com.github.juan1393.cleanArchitectureKotlin.app.di.module.ActivityModule
import com.github.juan1393.cleanArchitectureKotlin.app.di.scope.ActivityScope
import com.github.juan1393.cleanArchitectureKotlin.app.navigator.Navigator
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.signUp.SignUpUseCase
import com.github.juan1393.cleanArchitectureKotlin.ui.signUp.activity.SignUpActivity
import com.github.juan1393.cleanArchitectureKotlin.ui.signUp.activity.SignUpView
import com.github.juan1393.cleanArchitectureKotlin.ui.signUp.presenter.SignUpPresenter
import dagger.Module
import dagger.Provides


@Module
class SignUpActivityModule(activity: SignUpActivity) : ActivityModule(activity) {

    @Provides @ActivityScope
    fun provideSignUpView(): SignUpView = activity as SignUpView

    @Provides @ActivityScope
    fun provideSignUpPresenter(view: SignUpView, navigator: Navigator, signUpUseCase: SignUpUseCase)
            = SignUpPresenter(view, navigator, signUpUseCase)
}