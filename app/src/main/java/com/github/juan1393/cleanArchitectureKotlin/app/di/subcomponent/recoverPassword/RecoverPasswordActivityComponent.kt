package com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.recoverPassword

import com.github.juan1393.cleanArchitectureKotlin.app.di.scope.ActivityScope
import com.github.juan1393.cleanArchitectureKotlin.ui.recoverPassword.activity.RecoverPasswordActivity
import dagger.Subcomponent


@ActivityScope
@Subcomponent(modules = arrayOf(
        RecoverPasswordActivityModule::class
))
interface RecoverPasswordActivityComponent {
    fun injectTo(activity: RecoverPasswordActivity)
}