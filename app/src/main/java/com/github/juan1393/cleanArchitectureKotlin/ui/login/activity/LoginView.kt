package com.github.juan1393.cleanArchitectureKotlin.ui.login.activity

import com.github.juan1393.cleanArchitectureKotlin.ui.base.PresentationView

interface LoginView: PresentationView {
    
    fun showIncorrectEmailFormatError()

    fun showIncorrectPasswordFormatError()

    fun showIncorrectLoginUserDataError()

    fun showLoginLoading()

    fun hideLoginLoading()
}
