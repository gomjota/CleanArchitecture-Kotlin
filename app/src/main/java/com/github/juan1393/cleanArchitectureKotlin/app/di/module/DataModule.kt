package com.github.juan1393.cleanArchitectureKotlin.app.di.module

import com.github.juan1393.cleanArchitectureKotlin.App
import com.github.juan1393.cleanArchitectureKotlin.data.source.cache.CacheDataSource
import com.github.juan1393.cleanArchitectureKotlin.data.source.disk.DiskDataSource
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.NetworkDataSource
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.manager.NetworkClientManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides @Singleton
    fun provideNetworkDataSource(networkClientManager: NetworkClientManager)
            = NetworkDataSource(networkClientManager)

    @Provides @Singleton
    fun provideDiskDataSource(appContext: App)
            = DiskDataSource(appContext)

    @Provides @Singleton
    fun provideCacheDataSource()
            = CacheDataSource()

    @Provides @Singleton
    fun provideNetworkClientManager(diskDataSource: DiskDataSource)
            = NetworkClientManager(diskDataSource)
}