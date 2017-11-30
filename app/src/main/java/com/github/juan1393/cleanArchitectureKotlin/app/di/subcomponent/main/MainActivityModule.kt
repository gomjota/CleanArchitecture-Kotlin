package com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.main

import com.github.juan1393.cleanArchitectureKotlin.app.di.module.ActivityModule
import com.github.juan1393.cleanArchitectureKotlin.app.di.scope.ActivityScope
import com.github.juan1393.cleanArchitectureKotlin.app.navigator.Navigator
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.signOut.SignOutUseCase
import com.github.juan1393.cleanArchitectureKotlin.app.ui.main.activity.MainActivity
import com.github.juan1393.cleanArchitectureKotlin.app.ui.main.activity.MainView
import com.github.juan1393.cleanArchitectureKotlin.app.ui.main.presenter.MainPresenter
import dagger.Module
import dagger.Provides


@Module
class MainActivityModule(activity: MainActivity) : ActivityModule(activity) {

    @Provides @ActivityScope
    fun provideMainView(): MainView = activity as MainView

    @Provides @ActivityScope
    fun provideMainPresenter(view: MainView, navigator: Navigator, signOutUseCase: SignOutUseCase)
            = MainPresenter(view, navigator, signOutUseCase)
}
