package com.github.juan1393.cleanArchitectureKotlin.ui.signIn.presenter

import com.github.juan1393.cleanArchitectureKotlin.app.navigator.Navigator
import com.github.juan1393.cleanArchitectureKotlin.domain.model.User
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.signIn.SignInRequest
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.signIn.SignInResponse
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.signIn.SignInUseCase
import com.github.juan1393.cleanArchitectureKotlin.ui.base.Presenter
import com.github.juan1393.cleanArchitectureKotlin.ui.signIn.activity.SignInView

class SignInPresenter(override val view: SignInView,
                      override val navigator: Navigator,
                      var signInUseCase: SignInUseCase) :
        Presenter<SignInView>(), SignInRequest.Validator, SignInResponse {

    fun signIn(name: String, surname: String, email: String, password: String,
               repeatedPassword: String) {
        view.showSignInLoading()

        val request = SignInRequest(name, surname, email, password, repeatedPassword, this)
        signInUseCase.execute(request, this)
    }

    override fun onUserSignedIn(user: User) {
        navigator.toMain()
    }

    override fun onUserAlreadyExists() {
        view.showUserAlreadyExistsError()
        clearView()
    }

    override fun onIncorrectNameFormat() {
        view.showIncorrectNameFormatError()
        clearView()
    }

    override fun onIncorrectSurnameFormat() {
        view.showIncorrectSurnameFormatError()
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

    override fun onIncorrectMatchingPasswords() {
        view.showIncorrectMatchingPasswordsError()
        clearView()
    }

    override fun clearView() {
        view.hideSignInLoading()
    }

}
