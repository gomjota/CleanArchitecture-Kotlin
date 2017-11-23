package com.github.juan1393.cleanArchitectureKotlin.data.source.network.manager


import com.github.juan1393.cleanArchitectureKotlin.BuildConfig
import com.github.juan1393.cleanArchitectureKotlin.app.util.HASH
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.HttpUrl


object NetworkServiceManager {

    private val API_BASE_URL = BuildConfig.API_URL
    private val MARVEL_API_BASE_URL = BuildConfig.MARVEL_API_URL

    private val MARVEL_PRIVATE_KEY = BuildConfig.MARVEL_API_PRIVATE_KEY
    private val MARVEL_PUBLIC_KEY = BuildConfig.MARVEL_API_PUBLIC_KEY

    private var httpClient = OkHttpClient.Builder()
    private var retrofit: Retrofit? = null

    private val GSON = GsonBuilder()
            .create()

    var builder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GSON))

    var marvelBuilder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(MARVEL_API_BASE_URL)
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
        return build(builder, serviceClass)
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
        return build(builder, serviceClass)
    }

    internal fun <S> createMarvelAuthService(serviceClass: Class<S>): S {
        clearInterceptors()
        httpClient.addInterceptor { chain ->
            val original = chain.request()

            val originalHttpUrl = original.url()

            val currentTimestamp = System.currentTimeMillis().toString()
            val md5Digest = HASH.md5(currentTimestamp + MARVEL_PRIVATE_KEY + MARVEL_PUBLIC_KEY)

            val url = originalHttpUrl.newBuilder()
                    .addQueryParameter("apikey", BuildConfig.MARVEL_API_PUBLIC_KEY)
                    .addQueryParameter("ts", currentTimestamp)
                    .addQueryParameter("hash", md5Digest)
                    .build()

            val requestBuilder = original.newBuilder()
                    .header("Accept", "application/json")
                    .url(url)
                    .method(original.method(), original.body())

            val request = requestBuilder.build()
            chain.proceed(request)
        }
        return build(marvelBuilder, serviceClass)
    }

    private fun <S> build(builder: Retrofit.Builder, serviceClass: Class<S>): S {
        val client = httpClient.build()
        retrofit = builder.client(client).build()
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
