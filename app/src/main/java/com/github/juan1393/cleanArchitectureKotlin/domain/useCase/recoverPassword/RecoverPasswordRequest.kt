package com.github.juan1393.cleanArchitectureKotlin.domain.useCase.recoverPassword

import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.base.BaseRequest
import com.github.juan1393.cleanArchitectureKotlin.domain.validator.UserValidator

class RecoverPasswordRequest(val email: String,
                             private val validator: Validator) :
        BaseRequest() {

    override fun validate(): Boolean {
        if (!UserValidator.isEmailFormatValid(email)) {
            validator.onEmailFormatNotValid()
            return false
        }

        return true
    }

    interface Validator {
        fun onEmailFormatNotValid()
    }
}
