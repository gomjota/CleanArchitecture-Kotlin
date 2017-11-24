package com.github.juan1393.cleanArchitectureKotlin.ui.comicDetail.presenter

import android.content.Intent
import com.github.juan1393.cleanArchitectureKotlin.app.navigator.Navigator
import com.github.juan1393.cleanArchitectureKotlin.domain.model.Comic
import com.github.juan1393.cleanArchitectureKotlin.ui.base.Presenter
import com.github.juan1393.cleanArchitectureKotlin.ui.comicDetail.activity.ComicDetailView
import com.github.juan1393.cleanArchitectureKotlin.ui.comicDetail.displayModel.ComicDetailDisplayModel


class ComicDetailPresenter(override val view: ComicDetailView,
                           override val navigator: Navigator) :
        Presenter<ComicDetailView> {

    companion object {
        val COMIC_PARAMETER = "comic"
    }

    fun setIntentParams(intent: Intent) {
        val comic = intent.extras!!.getSerializable(COMIC_PARAMETER) as Comic
        val comicDetailDisplayModel = ComicDetailDisplayModel(comic)

        view.setHeaderImage(comicDetailDisplayModel.imageUrl)
        view.setTitle(comicDetailDisplayModel.title)
        view.setDescription(comicDetailDisplayModel.description)
        view.setCharacters(comicDetailDisplayModel.characters)
        view.setCreators(comicDetailDisplayModel.creators)
        view.setPrice(comicDetailDisplayModel.price)
    }

    fun onToolbarClicked() {
        navigator.finishActivity()
    }

    override fun clearView() {

    }

}