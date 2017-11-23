package com.github.juan1393.cleanArchitectureKotlin.app.di.module

import com.github.juan1393.cleanArchitectureKotlin.data.mapper.ComicEntityDataMapper
import com.github.juan1393.cleanArchitectureKotlin.data.mapper.UserEntityDataMapper
import com.github.juan1393.cleanArchitectureKotlin.data.repository.ComicRepository
import com.github.juan1393.cleanArchitectureKotlin.data.source.cache.CacheDataSource
import com.github.juan1393.cleanArchitectureKotlin.data.source.disk.DiskDataSource
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.NetworkDataSource
import com.github.juan1393.cleanArchitectureKotlin.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(networkDataSource: NetworkDataSource, diskDataSource: DiskDataSource,
                              cacheDataSource: CacheDataSource, userEntityDataMapper: UserEntityDataMapper)
            = UserRepository(networkDataSource, diskDataSource, cacheDataSource, userEntityDataMapper)

    @Provides
    @Singleton
    fun provideComicRepository(networkDataSource: NetworkDataSource, diskDataSource: DiskDataSource,
                               cacheDataSource: CacheDataSource, comicEntityDataMapper: ComicEntityDataMapper)
            = ComicRepository(networkDataSource, diskDataSource, cacheDataSource, comicEntityDataMapper)
}