package com.github.juan1393.cleanArchitectureKotlin.app.ui.comics.adapter.displayModel

import com.github.juan1393.cleanArchitectureKotlin.domain.model.Comic
import java.util.ArrayList


class ComicsDisplayModel(comics: List<Comic>) {

    private val comicDisplayModels = ArrayList<ComicDisplayModel>()

    init {
        comics.mapTo(comicDisplayModels) { ComicDisplayModel(it) }
    }

    fun get(position: Int): ComicDisplayModel = comicDisplayModels[position]

    fun size(): Int = comicDisplayModels.size

    inner class ComicDisplayModel(comic: Comic) {
        val title: String = comic.title!!
        val thumbnail: String = comic.thumbnailUrl!!
    }
}
