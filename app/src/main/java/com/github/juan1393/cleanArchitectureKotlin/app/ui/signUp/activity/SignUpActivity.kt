package com.github.juan1393.cleanArchitectureKotlin.app.ui.signUp.activity

import butterknife.OnClick
import com.github.juan1393.cleanArchitectureKotlin.BuildConfig
import com.github.juan1393.cleanArchitectureKotlin.R
import com.github.juan1393.cleanArchitectureKotlin.app.di.component.ApplicationComponent
import com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.signUp.SignUpActivityModule
import com.github.juan1393.cleanArchitectureKotlin.app.ui.base.*
import com.github.juan1393.cleanArchitectureKotlin.app.ui.signUp.presenter.SignUpPresenter
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.progress_bar_default.*
import javax.inject.Inject

class SignUpActivity : BaseActivity(), SignUpView {

    @Inject
    lateinit var presenter: SignUpPresenter

    override var layoutId: Int = R.layout.activity_sign_up

    override fun setupInjection(applicationComponent: ApplicationComponent) {
        applicationComponent.plus(SignUpActivityModule(this))
                .injectTo(this)
    }

    override fun showIncorrectNameFormatError() {
        toast(getString(R.string.sign_in_error_name_format, BuildConfig.MIN_NAME_LENGTH))
    }

    override fun showIncorrectSurnameFormatError() {
        toast(getString(R.string.sign_in_error_surname_format, BuildConfig.MIN_SURNAME_LENGTH))
    }

    override fun showIncorrectEmailFormatError() {
        toast(getString(R.string.sign_in_error_email_format))
    }

    override fun showIncorrectPasswordFormatError() {
        toast(getString(R.string.sign_in_error_password_format))
    }

    override fun showUserAlreadyExistsError() {
        toast(getString(R.string.sign_in_error_user_already_exists))
    }

    override fun showIncorrectMatchingPasswordsError() {
        toast(getString(R.string.sign_in_error_password_not_match))
    }

    override fun showSignUpLoading() {
        progress_wheel.visible()
        button_sign_in.gone()
    }

    override fun hideSignUpLoading() {
        progress_wheel.gone()
        button_sign_in.visible()
    }

    @OnClick(R.id.button_sign_in)
    fun onClick() {
        presenter.signUp(
                input_name.text(),
                input_surname.text(),
                input_email.text(),
                input_password.text(),
                input_repeat_password.text())
    }

}
