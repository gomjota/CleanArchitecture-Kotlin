package com.github.juan1393.cleanArchitectureKotlin.data.source.network.model


class NetworkError {

    var error: String? = null

    enum class Code constructor(private val code: String) {
        INCORRECT_AUTHENTICATION_CREDENTIALS("ERROR_1000"),
        USER_ALREADY_EXISTS("ERROR_2000"),
        ERROR_UPDATING_USER("ERROR_3000"),
        ERROR_DELETING_USER("ERROR_4000"),
        ERROR_CREATING_USER("ERROR_5000"),
        USER_NOT_FOUND("ERROR_6000");

        override fun toString(): String {
            return code
        }
    }
}
