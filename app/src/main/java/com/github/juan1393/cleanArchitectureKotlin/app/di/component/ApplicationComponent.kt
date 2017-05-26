package com.github.juan1393.cleanArchitectureKotlin.app.di.component

import com.github.juan1393.cleanArchitectureKotlin.app.di.module.ApplicationModule
import com.github.juan1393.cleanArchitectureKotlin.app.di.module.DataModule
import com.github.juan1393.cleanArchitectureKotlin.app.di.module.DomainModule
import com.github.juan1393.cleanArchitectureKotlin.app.di.module.RepositoryModule
import com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.login.LoginActivityComponent
import com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.login.LoginActivityModule
import com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.main.MainActivityComponent
import com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.main.MainActivityModule
import com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.recoverPassword.RecoverPasswordActivityComponent
import com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.recoverPassword.RecoverPasswordActivityModule
import com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.signIn.SignInActivityComponent
import com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.signIn.SignInActivityModule
import com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.splash.SplashActivityComponent
import com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.splash.SplashActivityModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        DataModule::class,
        RepositoryModule::class,
        DomainModule::class
))
interface ApplicationComponent {
    fun plus(module: SplashActivityModule): SplashActivityComponent
    fun plus(module: LoginActivityModule): LoginActivityComponent
    fun plus(module: SignInActivityModule): SignInActivityComponent
    fun plus(module: RecoverPasswordActivityModule): RecoverPasswordActivityComponent
    fun plus(module: MainActivityModule): MainActivityComponent
}