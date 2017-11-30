package com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.main

import com.github.juan1393.cleanArchitectureKotlin.app.di.scope.ActivityScope
import com.github.juan1393.cleanArchitectureKotlin.app.ui.main.activity.MainActivity
import dagger.Subcomponent


@ActivityScope
@Subcomponent(modules = arrayOf(
        MainActivityModule::class
))
interface MainActivityComponent {
    fun injectTo(activity: MainActivity)
}