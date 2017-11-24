package com.github.juan1393.cleanArchitectureKotlin.data.mapper

import android.net.Network
import com.github.juan1393.cleanArchitectureKotlin.data.entity.CharacterEntity
import com.github.juan1393.cleanArchitectureKotlin.data.entity.ComicEntity
import com.github.juan1393.cleanArchitectureKotlin.data.entity.CreatorEntity
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.request.getComics.NetworkGetComicsResponse
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.request.getComics.NetworkResult
import java.util.*


class NetworkGetComicsResponseToComicEntityMapper : Mapper<NetworkGetComicsResponse, List<ComicEntity>> {

    override fun map(input: NetworkGetComicsResponse): List<ComicEntity> =
            input.data.results.map {
                ComicEntity(
                        getId(it),
                        getTitle(it),
                        getDescription(it),
                        getPageCount(it),
                        getPrintPrice(it),
                        getThumbnailUrl(it),
                        getImagesUrl(it),
                        getCreators(it),
                        getCharacters(it)
                )

            }

    private fun getId(input: NetworkResult): Int? = input.id

    private fun getTitle(input: NetworkResult): String? = input.title

    private fun getDescription(input: NetworkResult): String? = input.description

    private fun getPageCount(input: NetworkResult): Int? = input.pageCount

    private fun getPrintPrice(input: NetworkResult): Float? =
            input.prices?.first { it.type == "printPrice" }?.price

    private fun getThumbnailUrl(input: NetworkResult): String? =
            input.thumbnail?.path + "." + input.thumbnail?.extension

    private fun getImagesUrl(input: NetworkResult): List<String>? =
            input.images?.map { it.path + "." + it.extension }

    private fun getCreators(input: NetworkResult): List<CreatorEntity>? =
            input.creators?.creators?.map {
                CreatorEntity(
                        it.name,
                        it.role
                )
            }

    private fun getCharacters(input: NetworkResult): List<CharacterEntity>? =
            input.characters?.characters?.map {
                CharacterEntity(
                        it.name
                )
            }
}