package com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.login

import com.github.juan1393.cleanArchitectureKotlin.app.di.scope.ActivityScope
import com.github.juan1393.cleanArchitectureKotlin.ui.login.activity.LoginActivity
import dagger.Subcomponent


@ActivityScope
@Subcomponent(modules = arrayOf(
        LoginActivityModule::class
))
interface LoginActivityComponent {
    fun injectTo(activity: LoginActivity)
}