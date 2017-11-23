package com.github.juan1393.cleanArchitectureKotlin.app.di.module

import com.github.juan1393.cleanArchitectureKotlin.App
import com.github.juan1393.cleanArchitectureKotlin.data.mapper.ComicEntityDataMapper
import com.github.juan1393.cleanArchitectureKotlin.data.mapper.NetworkAuthenticationResponseToUserEntityMapper
import com.github.juan1393.cleanArchitectureKotlin.data.mapper.NetworkGetComicsResponseToComicEntityMapper
import com.github.juan1393.cleanArchitectureKotlin.data.mapper.UserEntityDataMapper
import com.github.juan1393.cleanArchitectureKotlin.data.source.cache.CacheDataSource
import com.github.juan1393.cleanArchitectureKotlin.data.source.disk.DiskDataSource
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.NetworkDataSource
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.manager.NetworkClientManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideNetworkDataSource(networkClientManager: NetworkClientManager,
                                 networkAuthenticationResponseToUserEntityMapper: NetworkAuthenticationResponseToUserEntityMapper,
                                 networkGetComicsResponseToComicEntityMapper: NetworkGetComicsResponseToComicEntityMapper)
            = NetworkDataSource(
            networkClientManager,
            networkAuthenticationResponseToUserEntityMapper,
            networkGetComicsResponseToComicEntityMapper)

    @Provides
    @Singleton
    fun provideDiskDataSource(appContext: App)
            = DiskDataSource(appContext)

    @Provides
    @Singleton
    fun provideCacheDataSource()
            = CacheDataSource()

    @Provides
    @Singleton
    fun provideNetworkClientManager(diskDataSource: DiskDataSource)
            = NetworkClientManager(diskDataSource)

    @Provides
    @Singleton
    fun provideNetworkAuthenticationResponseToUserEntityMapper()
            = NetworkAuthenticationResponseToUserEntityMapper()

    @Provides
    @Singleton
    fun provideNetworkGetComicsResponseToComicEntityMapper()
            = NetworkGetComicsResponseToComicEntityMapper()

    @Provides
    @Singleton
    fun provideUserEntityDataMapper()
            = UserEntityDataMapper()

    @Provides
    @Singleton
    fun provideComicEntityDataMapper()
            = ComicEntityDataMapper()
}