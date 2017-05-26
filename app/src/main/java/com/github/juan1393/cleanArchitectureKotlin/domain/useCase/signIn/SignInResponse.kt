package com.github.juan1393.cleanArchitectureKotlin.domain.useCase.signIn

import com.github.juan1393.cleanArchitectureKotlin.domain.model.User
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.base.BaseResponse


interface SignInResponse : BaseResponse {

    fun onUserSignedIn(user: User)

    fun onUserAlreadyExists()
}
