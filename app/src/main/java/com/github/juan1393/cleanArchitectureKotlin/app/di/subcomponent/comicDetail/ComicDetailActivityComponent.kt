package com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.comicDetail

import com.github.juan1393.cleanArchitectureKotlin.app.di.scope.ActivityScope
import com.github.juan1393.cleanArchitectureKotlin.ui.comicDetail.activity.ComicDetailActivity
import dagger.Subcomponent


@ActivityScope
@Subcomponent(modules = arrayOf(
        ComicDetailActivityModule::class
))
interface ComicDetailActivityComponent {
    fun injectTo(activity: ComicDetailActivity)
}