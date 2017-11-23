package com.github.juan1393.cleanArchitectureKotlin.ui.login.presenter

import com.github.juan1393.cleanArchitectureKotlin.app.navigator.Navigator
import com.github.juan1393.cleanArchitectureKotlin.domain.model.User
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.login.LoginRequest
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.login.LoginResponse
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.login.LoginUseCase
import com.github.juan1393.cleanArchitectureKotlin.ui.base.Presenter
import com.github.juan1393.cleanArchitectureKotlin.ui.login.activity.LoginView


class LoginPresenter(override val view: LoginView,
                     override val navigator: Navigator,
                     var loginUseCase: LoginUseCase) :
        Presenter<LoginView>, LoginRequest.Validator, LoginResponse {

    fun login(email: String, password: String) {
        view.showLoginLoading()

        val request = LoginRequest(email, password, this)
        loginUseCase.execute(request, this)
    }

    fun navigateToSignUp() = navigator.toSignUp()
    fun navigateToRecoverPassword() = navigator.toRecoverPassword()

    override fun onUserLoggedIn(user: User) {
        navigator.toMain()
    }

    override fun onIncorrectLoginUserData() {
        view.showIncorrectLoginUserDataError()
        clearView()
    }

    override fun onIncorrectEmailFormat() {
        view.showIncorrectEmailFormatError()
        clearView()
    }

    override fun onIncorrectPasswordFormat() {
        view.showIncorrectPasswordFormatError()
        clearView()
    }

    override fun clearView() {
        view.hideLoginLoading()
    }
}
