package com.github.juan1393.cleanArchitectureKotlin.domain.useCase.signUp

import com.github.juan1393.cleanArchitectureKotlin.app.util.HASH
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.base.BaseRequest
import com.github.juan1393.cleanArchitectureKotlin.domain.validator.UserValidator


class SignUpRequest(var name: String, var surname: String,
                    var email: String, var password: String,
                    var repeatedPassword: String,
                    private val validator: Validator) : BaseRequest {

    fun securePassword() {
        this.password = HASH.md5(password)
    }

    override fun validate(): Boolean {
        if (!(UserValidator isNameValid (name))) {
            validator.onIncorrectNameFormat()
            return false
        }

        if (!(UserValidator isSurnameValid (surname))) {
            validator.onIncorrectSurnameFormat()
            return false
        }

        if (!(UserValidator isEmailFormatValid (email))) {
            validator.onIncorrectEmailFormat()
            return false
        }

        if (!(UserValidator isPasswordValid (password))) {
            validator.onIncorrectPasswordFormat()
            return false
        }

        if (!UserValidator.arePasswordsEquals(password, repeatedPassword)) {
            validator.onIncorrectMatchingPasswords()
            return false
        }

        return true
    }

    interface Validator {
        fun onIncorrectNameFormat()

        fun onIncorrectSurnameFormat()

        fun onIncorrectEmailFormat()

        fun onIncorrectPasswordFormat()

        fun onIncorrectMatchingPasswords()
    }
}