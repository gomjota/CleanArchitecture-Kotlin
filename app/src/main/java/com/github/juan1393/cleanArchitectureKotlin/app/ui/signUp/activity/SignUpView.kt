package com.github.juan1393.cleanArchitectureKotlin.app.ui.signUp.activity

import com.github.juan1393.cleanArchitectureKotlin.app.ui.base.PresentationView


interface SignUpView: PresentationView {

    fun showIncorrectNameFormatError()

    fun showIncorrectSurnameFormatError()

    fun showIncorrectEmailFormatError()

    fun showIncorrectPasswordFormatError()

    fun showUserAlreadyExistsError()

    fun showIncorrectMatchingPasswordsError()

    fun showSignUpLoading()

    fun hideSignUpLoading()
}