package com.github.juan1393.cleanArchitectureKotlin.data.source.network.manager


import com.github.juan1393.cleanArchitectureKotlin.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkServiceManager {

    private val API_BASE_URL = BuildConfig.API_URL

    private var httpClient = OkHttpClient.Builder()
    private var retrofit: Retrofit? = null

    private val GSON = GsonBuilder()
            .create()

    var BUILDER: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GSON))

    internal fun <S> createService(serviceClass: Class<S>): S {
        clearInterceptors()
        httpClient.addInterceptor { chain ->
            val original = chain.request()

            val requestBuilder = original.newBuilder()
                    .header("Accept", "application/json")
                    .method(original.method(), original.body())

            val request = requestBuilder.build()
            chain.proceed(request)
        }
        return build(serviceClass)
    }

    internal fun <S> createAuthService(serviceClass: Class<S>, token: String): S {
        clearInterceptors()
        httpClient.addInterceptor { chain ->
            val original = chain.request()

            val requestBuilder = original.newBuilder()
                    .header("Authorization", token)
                    .header("Accept", "application/json")
                    .method(original.method(), original.body())

            val request = requestBuilder.build()
            chain.proceed(request)
        }
        return build(serviceClass)
    }

    private fun <S> build(serviceClass: Class<S>): S {
        val client = httpClient.build()
        retrofit = BUILDER.client(client).build()
        return retrofit!!.create(serviceClass)
    }

    private fun clearInterceptors() {
        val client = httpClient.build()
        httpClient = client.newBuilder()
        httpClient.networkInterceptors().clear()
        httpClient.interceptors().clear()
    }

    fun retrofit(): Retrofit? {
        return retrofit
    }
}
