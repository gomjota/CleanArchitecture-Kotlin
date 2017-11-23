package com.github.juan1393.cleanArchitectureKotlin.data.source.network.manager


import com.github.juan1393.cleanArchitectureKotlin.data.entity.TokenEntity
import com.github.juan1393.cleanArchitectureKotlin.data.exception.DataNotFoundException
import com.github.juan1393.cleanArchitectureKotlin.data.source.disk.DiskDataSource
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.service.API
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.service.MarvelAPI

class NetworkClientManager(val diskDataSource: DiskDataSource) {

    val client: API = NetworkServiceManager.createService(API::class.java)

    val authClient: API
        get() {
            return NetworkServiceManager.createAuthService(
                    API::class.java,
                    diskDataSource.getToken()?.token ?: throw DataNotFoundException())
        }

    val marvelAuthClient: MarvelAPI
        get() {
            return NetworkServiceManager.createMarvelAuthService(
                    MarvelAPI::class.java)
        }

    fun updateToken(token: String) {
        diskDataSource.deleteAllTokens()
        diskDataSource.insertToken(TokenEntity(token))
    }
}
