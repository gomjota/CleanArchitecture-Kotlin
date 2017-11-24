package com.github.juan1393.cleanArchitectureKotlin.data.mapper

import com.github.juan1393.cleanArchitectureKotlin.data.entity.CharacterEntity
import com.github.juan1393.cleanArchitectureKotlin.data.entity.ComicEntity
import com.github.juan1393.cleanArchitectureKotlin.data.entity.CreatorEntity
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.request.getComics.NetworkGetComicsResponse
import com.github.juan1393.cleanArchitectureKotlin.domain.model.Character
import com.github.juan1393.cleanArchitectureKotlin.domain.model.Comic
import com.github.juan1393.cleanArchitectureKotlin.domain.model.Creator
import java.util.*


class ComicEntityDataMapper: Mapper<ComicEntity, Comic> {

    override fun map(input: ComicEntity): Comic =
            Comic(
                    getId(input),
                    getTitle(input),
                    getDescription(input),
                    getPageCount(input),
                    getPrintPrice(input),
                    getThumbnailUrl(input),
                    getImagesUrl(input),
                    getCreators(input),
                    getCharacters(input)
            )

    private fun getId(input: ComicEntity): Int? = input.id

    private fun getTitle(input: ComicEntity): String? = input.title

    private fun getDescription(input: ComicEntity): String? = input.description

    private fun getPageCount(input: ComicEntity): Int? = input.pageCount

    private fun getPrintPrice(input: ComicEntity): Float? =
            input.printPrice

    private fun getThumbnailUrl(input: ComicEntity): String? =
            input.thumbnailUrl

    private fun getImagesUrl(input: ComicEntity): List<String>? =
            input.imagesUrl

    private fun getCreators(input: ComicEntity): List<Creator>? =
            input.creators?.map { Creator(it.name, it.role) }

    private fun getCharacters(input: ComicEntity): List<com.github.juan1393.cleanArchitectureKotlin.domain.model.Character>? =
            input.characters?.map { Character(it.name) }
}