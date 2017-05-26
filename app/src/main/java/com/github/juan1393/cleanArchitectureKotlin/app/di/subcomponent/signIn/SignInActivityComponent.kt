package com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.signIn

import com.github.juan1393.cleanArchitectureKotlin.app.di.scope.ActivityScope
import com.github.juan1393.cleanArchitectureKotlin.ui.signIn.activity.SignInActivity
import dagger.Subcomponent


@ActivityScope
@Subcomponent(modules = arrayOf(
        SignInActivityModule::class
))
interface SignInActivityComponent {
    fun injectTo(activity: SignInActivity)
}