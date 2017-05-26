package com.github.juan1393.cleanArchitectureKotlin.data.source.network.service


import com.github.juan1393.cleanArchitectureKotlin.data.source.network.model.body.NetworkLoginBody
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.model.body.NetworkSignInBody
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.request.base.auth.NetworkUserAuthenticationResponse

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface API {

    @POST("login")
    fun login(@Body networkLoginBody: NetworkLoginBody): Call<NetworkUserAuthenticationResponse>

    @POST("signin")
    fun signIn(@Body networkSignInBody: NetworkSignInBody): Call<NetworkUserAuthenticationResponse>

    @GET("forgot")
    fun recoverPassword(@Query("email") email: String): Call<Void>
}