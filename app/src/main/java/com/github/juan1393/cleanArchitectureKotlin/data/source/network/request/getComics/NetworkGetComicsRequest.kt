package com.github.juan1393.cleanArchitectureKotlin.data.source.network.request.getComics

import com.github.juan1393.cleanArchitectureKotlin.data.exception.NetworkConnectionException
import com.github.juan1393.cleanArchitectureKotlin.data.exception.NetworkServiceException
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.manager.NetworkClientManager
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.model.NetworkResponse
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.request.base.NetworkMarvelRequest
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.getComics.GetComicsRequest


class NetworkGetComicsRequest(private val getComicsRequest: GetComicsRequest,
                              networkClientManager: NetworkClientManager)
    : NetworkMarvelRequest<NetworkGetComicsResponse>(networkClientManager) {

    companion object {
        private val CHARACTER_ID = 1009220
        private val FORMAT = "comic"
        private val LIMIT = 20
    }

    @Throws(NetworkConnectionException::class, NetworkServiceException::class)
    override fun run(): NetworkResponse<NetworkGetComicsResponse> {
        val params = hashMapOf(
                "format" to FORMAT,
                "formatType" to FORMAT,
                "limit" to LIMIT)

        val call = API.getComics(params)
        return execute(call)
    }
}