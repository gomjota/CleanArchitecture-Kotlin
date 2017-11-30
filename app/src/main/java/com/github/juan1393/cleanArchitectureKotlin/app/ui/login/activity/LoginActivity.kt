package com.github.juan1393.cleanArchitectureKotlin.app.ui.login.activity

import android.view.View
import butterknife.OnClick
import com.github.juan1393.cleanArchitectureKotlin.R
import com.github.juan1393.cleanArchitectureKotlin.app.di.component.ApplicationComponent
import com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.login.LoginActivityModule
import com.github.juan1393.cleanArchitectureKotlin.app.ui.base.*
import com.github.juan1393.cleanArchitectureKotlin.app.ui.login.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.progress_bar_default.*
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginView {

    @Inject
    lateinit var presenter: LoginPresenter

    override var layoutId: Int = R.layout.activity_login

    override fun setupInjection(applicationComponent: ApplicationComponent) {
        applicationComponent.plus(LoginActivityModule(this))
                .injectTo(this)
    }

    override fun showIncorrectEmailFormatError() {
        toast(getString(R.string.login_error_email_format))
    }

    override fun showIncorrectPasswordFormatError() {
        toast(getString(R.string.login_error_password_format))
    }

    override fun showIncorrectLoginUserDataError() {
        toast(getString(R.string.login_error_login))
    }

    override fun showLoginLoading() {
        progress_wheel.visible()
        button_login.gone()
    }

    override fun hideLoginLoading() {
        progress_wheel.gone()
        button_login.visible()
    }

    @OnClick(R.id.text_recover_password, R.id.text_sign_in, R.id.button_login)
    fun onViewClicked(view: View) {
        when (view.id) {
            R.id.text_recover_password -> presenter.navigateToRecoverPassword()
            R.id.text_sign_in -> presenter.navigateToSignUp()
            R.id.button_login -> presenter.login(
                    input_email.text(),
                    input_password.text())
        }
    }
}
