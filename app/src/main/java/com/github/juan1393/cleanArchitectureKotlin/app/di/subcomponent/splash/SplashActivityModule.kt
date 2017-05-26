package com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.splash

import com.github.juan1393.cleanArchitectureKotlin.app.di.module.ActivityModule
import com.github.juan1393.cleanArchitectureKotlin.app.di.scope.ActivityScope
import com.github.juan1393.cleanArchitectureKotlin.app.navigator.Navigator
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.getCurrentUser.GetCurrentUserUseCase
import com.github.juan1393.cleanArchitectureKotlin.ui.splash.activity.SplashActivity
import com.github.juan1393.cleanArchitectureKotlin.ui.splash.activity.SplashView
import com.github.juan1393.cleanArchitectureKotlin.ui.splash.presenter.SplashPresenter
import dagger.Module
import dagger.Provides


@Module
class SplashActivityModule(activity: SplashActivity) : ActivityModule(activity) {

    @Provides @ActivityScope
    fun provideSplashView(): SplashView = activity as SplashView

    @Provides @ActivityScope
    fun provideSplashPresenter(view: SplashView, navigator: Navigator,
                               getCurrentUserUseCase: GetCurrentUserUseCase)
            = SplashPresenter(view, navigator, getCurrentUserUseCase)
}