package com.github.juan1393.cleanArchitectureKotlin.app.ui.login.activity

import com.github.juan1393.cleanArchitectureKotlin.app.ui.base.PresentationView

interface LoginView: PresentationView {
    
    fun showIncorrectEmailFormatError()

    fun showIncorrectPasswordFormatError()

    fun showIncorrectLoginUserDataError()

    fun showLoginLoading()

    fun hideLoginLoading()
}
