package com.github.juan1393.cleanArchitectureKotlin.domain.useCase.recoverPassword

import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.base.BaseResponse


interface RecoverPasswordResponse : BaseResponse {

    fun onEmailSentToRecoverPassword()

    fun onUserNotFoundError()
}
