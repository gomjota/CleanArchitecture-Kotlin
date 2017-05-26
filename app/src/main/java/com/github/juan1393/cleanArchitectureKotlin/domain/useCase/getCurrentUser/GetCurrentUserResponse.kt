package com.github.juan1393.cleanArchitectureKotlin.domain.useCase.getCurrentUser

import com.github.juan1393.cleanArchitectureKotlin.domain.model.User
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.base.BaseResponse


interface GetCurrentUserResponse: BaseResponse {

    fun onCurrentUserReceived(user: User)

}