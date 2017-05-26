package com.github.juan1393.cleanArchitectureKotlin.ui.recoverPassword.activity

import com.github.juan1393.cleanArchitectureKotlin.ui.base.PresentationView


interface RecoverPasswordView: PresentationView {

    fun showIncorrectEmailFormatError()

    fun showUserNotFoundError()

    fun showRecoverPasswordLoading()

    fun hideRecoverPasswordLoading()
}