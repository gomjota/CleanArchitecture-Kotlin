package com.github.juan1393.cleanArchitectureKotlin.data.source.network.manager


import com.github.juan1393.cleanArchitectureKotlin.data.exception.DataNotFoundException
import com.github.juan1393.cleanArchitectureKotlin.data.source.disk.DiskDataSource
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.service.API
import com.github.juan1393.cleanArchitectureKotlin.domain.model.Token

class NetworkClientManager(val diskDataSource: DiskDataSource) {

    val client: API = NetworkServiceManager.createService(API::class.java)

    val authClient: API
        get() {
            return NetworkServiceManager.createAuthService(
                    API::class.java,
                    diskDataSource.getToken()?.token ?: throw DataNotFoundException())
        }

    fun updateToken(token: String) {
        diskDataSource.deleteAllTokens()
        diskDataSource.insertToken(Token(token))
    }
}
