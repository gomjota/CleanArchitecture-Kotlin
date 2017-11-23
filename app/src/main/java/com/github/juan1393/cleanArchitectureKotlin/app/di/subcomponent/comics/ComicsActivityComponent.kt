package com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.comics

import com.github.juan1393.cleanArchitectureKotlin.app.di.scope.ActivityScope
import com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.comics.ComicsActivityModule
import com.github.juan1393.cleanArchitectureKotlin.ui.comics.activity.ComicsActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = arrayOf(
        ComicsActivityModule::class
))
interface ComicsActivityComponent {
    fun injectTo(activity: ComicsActivity)
}