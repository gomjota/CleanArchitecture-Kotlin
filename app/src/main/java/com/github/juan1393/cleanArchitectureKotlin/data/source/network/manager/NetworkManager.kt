package com.github.juan1393.cleanArchitectureKotlin.data.source.network.manager


import com.github.juan1393.cleanArchitectureKotlin.data.exception.NetworkConnectionException
import com.github.juan1393.cleanArchitectureKotlin.data.exception.NetworkServiceException
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.model.NetworkError
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.model.NetworkResponse
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.request.base.NetworkBaseRequest

import java.io.IOException
import java.net.ConnectException
import java.net.UnknownHostException

object NetworkManager {

    @Throws(NetworkConnectionException::class, NetworkServiceException::class)
    fun <R> execute(networkBaseRequest: NetworkBaseRequest<R>): NetworkResponse<R> {
        val networkRetrofitResponse: retrofit2.Response<R>?
        try {
            networkRetrofitResponse = networkBaseRequest.call?.execute()
        } catch (e: ConnectException) {
            e.printStackTrace()
            throw NetworkConnectionException()
        } catch (e: UnknownHostException) {
            e.printStackTrace()
            throw NetworkConnectionException()
        } catch (e: Exception) {
            e.printStackTrace()
            throw NetworkServiceException()
        }

        if (networkRetrofitResponse != null) {
            if (!networkRetrofitResponse.isSuccessful) {
                try {
                    val networkError = parseError(networkRetrofitResponse)
                    if (networkError != null) {
                        return NetworkResponse(null, networkError)
                    }
                } catch (ignored: IOException) {
                }

                throw NetworkServiceException()
            }
            return NetworkResponse(networkRetrofitResponse.body())
        }

        throw NetworkServiceException()
    }

    @Throws(IOException::class)
    private fun parseError(response: retrofit2.Response<*>): NetworkError? {
        val converter = NetworkServiceManager.retrofit()?.responseBodyConverter<NetworkError>(
                NetworkError::class.java,
                arrayOfNulls<Annotation>(0))

        return converter!!.convert(response.errorBody())
    }
}
