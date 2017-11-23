package com.github.juan1393.cleanArchitectureKotlin.ui.comics.presenter

import com.github.juan1393.cleanArchitectureKotlin.app.navigator.Navigator
import com.github.juan1393.cleanArchitectureKotlin.domain.model.Comic
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.getComics.GetComicsRequest
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.getComics.GetComicsResponse
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.getComics.GetComicsUseCase
import com.github.juan1393.cleanArchitectureKotlin.ui.base.Presenter
import com.github.juan1393.cleanArchitectureKotlin.ui.comics.activity.ComicsView
import com.github.juan1393.cleanArchitectureKotlin.ui.comics.adapter.displayModel.ComicsDisplayModel


class ComicsPresenter(override val view: ComicsView,
                      override val navigator: Navigator,
                      private val getComicsUseCase: GetComicsUseCase) :
        Presenter<ComicsView>, GetComicsResponse {

    private var comics = listOf<Comic>()

    fun getComics() {
        val request = GetComicsRequest()
        getComicsUseCase.execute(request, this)
    }

    override fun onComicsReceived(comics: List<Comic>) {
        this.comics = comics
        val comicsDisplayModel = ComicsDisplayModel(comics)
        view.setDataInComicList(comicsDisplayModel)
        view.hideProgressWheel()
    }

    fun onItemOnListClicked(position: Int) {
        val comicSelected = comics[position]
        if (comicSelected.hasAllInfo()) {
            navigator.toComicDetail(comicSelected)
        } else {
            view.showComicHasNotAllInfoError()
        }
    }

    override fun clearView() {

    }

}