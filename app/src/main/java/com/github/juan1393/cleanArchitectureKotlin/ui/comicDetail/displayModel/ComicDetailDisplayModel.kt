package com.github.juan1393.cleanArchitectureKotlin.ui.comicDetail.displayModel

import com.github.juan1393.cleanArchitectureKotlin.domain.model.Comic
import java.text.SimpleDateFormat
import java.util.*


class ComicDetailDisplayModel(comic: Comic) {

    val imageUrl: String
    val title: String
    val description: String
    val characters: String
    val creators: String
    val price: String

    init {
        this.imageUrl = randomImage(comic)
        this.title = formatTitle(comic)
        this.description = formatDescription(comic)
        this.characters = formatCharacters(comic)
        this.creators = formatCreators(comic)
        this.price = formatPrice(comic)
    }

    private fun randomImage(comic: Comic): String {
        val random = Random()
        val index = random.nextInt(comic.imagesUrl!!.size)
        return comic.imagesUrl[index]
    }

    private fun formatTitle(comic: Comic): String = comic.title!!

    private fun formatDescription(comic: Comic) = comic.description!!

    private fun formatCharacters(comic: Comic): String {
        var characters = ""
        val size = comic.characters!!.size
        comic.characters!!.forEachIndexed { index, character ->
            characters += character.name
            if (index != size - 1) characters += ", "
        }

        return characters
    }

    private fun formatCreators(comic: Comic): String {
        var creators = ""
        val size = comic.creators!!.size
        comic.creators!!.forEachIndexed { index, creator ->
            creators += creator.name
            if (index != size - 1) creators += ", "
        }

        return creators
    }

    private fun formatPrice(comic: Comic): String = comic.printPrice.toString() + "$"
}
