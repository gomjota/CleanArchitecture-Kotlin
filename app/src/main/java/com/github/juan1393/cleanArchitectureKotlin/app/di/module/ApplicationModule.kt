package com.github.juan1393.cleanArchitectureKotlin.app.di.module

import android.content.Context
import com.github.juan1393.cleanArchitectureKotlin.App
import com.github.juan1393.cleanArchitectureKotlin.app.di.qualifier.ApplicationQualifier
import com.github.juan1393.cleanArchitectureKotlin.app.navigator.Navigator
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.executor.MainThread
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.executor.MainThreadImpl
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.executor.ThreadExecutor
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.executor.UseCaseExecutor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val app: App) {

    @Provides @Singleton
    fun provideApplication(): App = app

    @Provides @Singleton @ApplicationQualifier
    fun provideApplicationContext(): Context = app

    @Provides @Singleton
    fun provideNavigator(): Navigator = Navigator()

    @Provides @Singleton
    fun provideThreadExecutor(): UseCaseExecutor = ThreadExecutor()

    @Provides @Singleton
    fun provideMainThread(): MainThread = MainThreadImpl()
}
