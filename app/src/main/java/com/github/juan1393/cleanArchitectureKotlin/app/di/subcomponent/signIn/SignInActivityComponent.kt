package com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.signUp

import com.github.juan1393.cleanArchitectureKotlin.app.di.scope.ActivityScope
import com.github.juan1393.cleanArchitectureKotlin.app.ui.signUp.activity.SignUpActivity
import dagger.Subcomponent


@ActivityScope
@Subcomponent(modules = arrayOf(
        SignUpActivityModule::class
))
interface SignUpActivityComponent {
    fun injectTo(activity: SignUpActivity)
}