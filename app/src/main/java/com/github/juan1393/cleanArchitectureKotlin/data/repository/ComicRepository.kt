package com.github.juan1393.cleanArchitectureKotlin.data.repository

import com.github.juan1393.cleanArchitectureKotlin.data.mapper.ComicEntityDataMapper
import com.github.juan1393.cleanArchitectureKotlin.data.source.cache.CacheDataSource
import com.github.juan1393.cleanArchitectureKotlin.data.source.disk.DiskDataSource
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.NetworkDataSource
import com.github.juan1393.cleanArchitectureKotlin.domain.model.Comic
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.base.Response
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.getComics.GetComicsRequest

class ComicRepository(private val networkDataSource: NetworkDataSource,
                      private val diskDataSource: DiskDataSource,
                      private val cacheDataSource: CacheDataSource,
                      private val comicEntityDataMapper: ComicEntityDataMapper) {

    fun getComics(request: GetComicsRequest): Response<List<Comic>> {
        val response = networkDataSource.getComics(request)
        val comicEntities = response.data!!
        val comics = comicEntities.map { comicEntityDataMapper.map(it) }
        return Response(comics)
    }

}