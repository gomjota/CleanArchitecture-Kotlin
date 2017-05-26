package com.github.juan1393.cleanArchitectureKotlin.ui.login.activity

import android.view.View
import android.widget.Button
import android.widget.EditText
import butterknife.BindView
import butterknife.OnClick
import com.github.juan1393.cleanArchitectureKotlin.R
import com.github.juan1393.cleanArchitectureKotlin.app.di.component.ApplicationComponent
import com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.login.LoginActivityModule
import com.github.juan1393.cleanArchitectureKotlin.ui.base.BaseActivity
import com.github.juan1393.cleanArchitectureKotlin.ui.base.Presenter
import com.github.juan1393.cleanArchitectureKotlin.ui.base.toast
import com.github.juan1393.cleanArchitectureKotlin.ui.login.presenter.LoginPresenter
import com.pnikosis.materialishprogress.ProgressWheel
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginView {

    @Inject
    lateinit var presenter: LoginPresenter

    @BindView(R.id.input_email)
    lateinit var inputEmail: EditText
    @BindView(R.id.input_password)
    lateinit var inputPassword: EditText
    @BindView(R.id.button_login)
    lateinit var buttonLogin: Button
    @BindView(R.id.progress_wheel)
    lateinit var loadingLogin: ProgressWheel

    override var layoutId: Int = R.layout.activity_login

    override fun getPresenter(): Presenter<*> = presenter

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
        loadingLogin.visibility = View.VISIBLE
        buttonLogin.visibility = View.GONE
    }

    override fun hideLoginLoading() {
        loadingLogin.visibility = View.GONE
        buttonLogin.visibility = View.VISIBLE
    }

    @OnClick(R.id.text_recover_password, R.id.text_sign_in, R.id.button_login)
    fun onViewClicked(view: View) {
        when (view.id) {
            R.id.text_recover_password -> presenter.navigateToRecoverPassword()
            R.id.text_sign_in -> presenter.navigateToSignIn()
            R.id.button_login -> presenter.login(inputEmail.text.toString(),
                    inputPassword.text.toString())
        }
    }
}
