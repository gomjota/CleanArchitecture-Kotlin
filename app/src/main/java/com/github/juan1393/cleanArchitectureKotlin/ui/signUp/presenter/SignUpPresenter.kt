package com.github.juan1393.cleanArchitectureKotlin.ui.signUp.presenter

import com.github.juan1393.cleanArchitectureKotlin.app.navigator.Navigator
import com.github.juan1393.cleanArchitectureKotlin.domain.model.User
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.signUp.SignUpRequest
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.signUp.SignUpResponse
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.signUp.SignUpUseCase
import com.github.juan1393.cleanArchitectureKotlin.ui.base.Presenter
import com.github.juan1393.cleanArchitectureKotlin.ui.signUp.activity.SignUpView

class SignUpPresenter(override val view: SignUpView,
                      override val navigator: Navigator,
                      var signUpUseCase: SignUpUseCase) :
        Presenter<SignUpView>, SignUpRequest.Validator, SignUpResponse {

    fun signUp(name: String, surname: String, email: String, password: String,
               repeatedPassword: String) {
        view.showSignUpLoading()

        val request = SignUpRequest(name, surname, email, password, repeatedPassword, this)
        signUpUseCase.execute(request, this)
    }

    override fun onUserSignedIn(user: User) {
        //navigator.toMain()
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
        view.hideSignUpLoading()
    }

}
