package com.github.juan1393.cleanArchitectureKotlin.domain.validator

import com.github.juan1393.cleanArchitectureKotlin.BuildConfig
import com.github.juan1393.cleanArchitectureKotlin.app.util.Util


object UserValidator {

    fun isNameValid(name: String?): Boolean {
        if (name == null ||
                name.isEmpty() ||
                name.length < BuildConfig.MIN_NAME_LENGTH) {
            return false
        }

        return true
    }

    fun isSurnameValid(surname: String?): Boolean {
        if (surname == null ||
                surname.isEmpty() ||
                surname.length < BuildConfig.MIN_SURNAME_LENGTH) {
            return false
        }
        return true
    }

    fun isEmailFormatValid(email: String?): Boolean {
        if (email == null || !Util.isValidEmailFormat(email)) {
            return false
        }
        return true
    }

    fun isPasswordValid(password: String?): Boolean {
        val passwordPattern = "^(?=.*[0-9])" +
                "(?=.*[a-z])" +
                "(?=.*[A-Z])" +
                "(?=\\S+$)" +
                ".{8,}$"

        if (password == null || !password.matches(passwordPattern.toRegex())) {
            return false
        }
        return true
    }


    fun arePasswordsEquals(password: String, repeatPassword: String?): Boolean {
        if (repeatPassword == null || repeatPassword != password) {
            return false
        }
        return true
    }

    fun isPhoneLengthValid(phone: String?): Boolean {
        if (phone == null || phone.length != BuildConfig.PHONE_LENGTH) {
            return false
        }
        return true
    }
}