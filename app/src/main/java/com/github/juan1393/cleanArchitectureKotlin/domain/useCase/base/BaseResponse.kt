package com.github.juan1393.cleanArchitectureKotlin.domain.useCase.base

interface BaseResponse {

    fun onNetworkConnectionError()

    fun onNetworkServiceError()

    fun onUnknownError()

    fun onUserIsNotLoggedIn()
}
