package com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.comics

import com.github.juan1393.cleanArchitectureKotlin.app.di.module.ActivityModule
import com.github.juan1393.cleanArchitectureKotlin.app.di.scope.ActivityScope
import com.github.juan1393.cleanArchitectureKotlin.app.navigator.Navigator
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.getComics.GetComicsUseCase
import com.github.juan1393.cleanArchitectureKotlin.app.ui.comics.activity.ComicsActivity
import com.github.juan1393.cleanArchitectureKotlin.app.ui.comics.activity.ComicsView
import com.github.juan1393.cleanArchitectureKotlin.app.ui.comics.presenter.ComicsPresenter
import dagger.Module
import dagger.Provides

@Module
class ComicsActivityModule(activity: ComicsActivity) : ActivityModule(activity) {

    @Provides
    @ActivityScope
    fun provideComicsView(): ComicsView = activity as ComicsView

    @Provides
    @ActivityScope
    fun provideComicsPresenter(view: ComicsView, navigator: Navigator, getComicsUseCase: GetComicsUseCase)
            = ComicsPresenter(view, navigator, getComicsUseCase)
}