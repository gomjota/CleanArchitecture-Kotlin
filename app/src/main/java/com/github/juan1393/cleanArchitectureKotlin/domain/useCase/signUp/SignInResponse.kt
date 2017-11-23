package com.github.juan1393.cleanArchitectureKotlin.domain.useCase.signUp

import com.github.juan1393.cleanArchitectureKotlin.domain.model.User
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.base.BaseResponse


interface SignUpResponse : BaseResponse {

    fun onUserSignedIn(user: User)

    fun onUserAlreadyExists()
}
