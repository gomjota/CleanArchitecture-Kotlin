package com.github.juan1393.cleanArchitectureKotlin.domain.useCase.login

import com.github.juan1393.cleanArchitectureKotlin.domain.model.User
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.base.BaseResponse


interface LoginResponse : BaseResponse {

    fun onUserLoggedIn(user: User)

    fun onIncorrectLoginUserData()
}
