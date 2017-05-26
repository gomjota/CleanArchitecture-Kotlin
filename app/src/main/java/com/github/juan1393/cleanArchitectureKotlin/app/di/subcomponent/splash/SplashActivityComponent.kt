package com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.splash

import com.github.juan1393.cleanArchitectureKotlin.app.di.scope.ActivityScope
import com.github.juan1393.cleanArchitectureKotlin.ui.splash.activity.SplashActivity
import dagger.Subcomponent


@ActivityScope
@Subcomponent(modules = arrayOf(
        SplashActivityModule::class
))
interface SplashActivityComponent {
    fun injectTo(activity: SplashActivity)
}