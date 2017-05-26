package com.github.juan1393.cleanArchitectureKotlin.app.util

import java.util.regex.Pattern


object Util {

    fun isValidEmailFormat(email: String): Boolean {
        val validEmailRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
                Pattern.CASE_INSENSITIVE)
        val matcher = validEmailRegex.matcher(email)
        return matcher.find()
    }
}