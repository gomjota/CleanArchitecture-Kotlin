package com.github.juan1393.cleanArchitectureKotlin.data.source.network.service

import com.github.juan1393.cleanArchitectureKotlin.data.source.network.request.getComics.NetworkGetComicsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap


interface MarvelAPI {

    @GET("v1/public/characters/{characterId}/comics")
    fun getComics(@Path("characterId") characterId: Int,
                  @QueryMap params: HashMap<String, Any>): Call<NetworkGetComicsResponse>
}