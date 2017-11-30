package com.github.juan1393.cleanArchitectureKotlin.app.ui.comics.activity

import com.github.juan1393.cleanArchitectureKotlin.app.ui.base.PresentationView
import com.github.juan1393.cleanArchitectureKotlin.app.ui.comics.adapter.displayModel.ComicsDisplayModel


interface ComicsView: PresentationView {

    fun setDataInComicList(comicsDisplayModel: ComicsDisplayModel)

    fun showProgressWheel()

    fun hideProgressWheel()

    fun showCharacterComicsNotFoundError()

    fun showNetworkConnectionError()

    fun showComicHasNotAllInfoError()
}