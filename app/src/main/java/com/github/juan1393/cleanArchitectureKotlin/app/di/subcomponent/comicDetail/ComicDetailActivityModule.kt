package com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.comicDetail

import com.github.juan1393.cleanArchitectureKotlin.app.di.module.ActivityModule
import com.github.juan1393.cleanArchitectureKotlin.app.di.scope.ActivityScope
import com.github.juan1393.cleanArchitectureKotlin.app.navigator.Navigator
import com.github.juan1393.cleanArchitectureKotlin.app.ui.comicDetail.activity.ComicDetailActivity
import com.github.juan1393.cleanArchitectureKotlin.app.ui.comicDetail.activity.ComicDetailView
import com.github.juan1393.cleanArchitectureKotlin.app.ui.comicDetail.presenter.ComicDetailPresenter
import dagger.Module
import dagger.Provides


@Module
class ComicDetailActivityModule(activity: ComicDetailActivity) : ActivityModule(activity) {

    @Provides
    @ActivityScope
    fun provideComicDetailView(): ComicDetailView = activity as ComicDetailView

    @Provides
    @ActivityScope
    fun provideComicDetailPresenter(view: ComicDetailView, navigator: Navigator)
            = ComicDetailPresenter(view, navigator)
}