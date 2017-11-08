package com.github.juan1393.cleanArchitectureKotlin.ui.signIn.activity

import android.widget.Button
import android.widget.EditText
import butterknife.BindView
import butterknife.OnClick
import com.github.juan1393.cleanArchitectureKotlin.BuildConfig
import com.github.juan1393.cleanArchitectureKotlin.R
import com.github.juan1393.cleanArchitectureKotlin.app.di.component.ApplicationComponent
import com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.signIn.SignInActivityModule
import com.github.juan1393.cleanArchitectureKotlin.ui.base.*
import com.github.juan1393.cleanArchitectureKotlin.ui.signIn.presenter.SignInPresenter
import com.pnikosis.materialishprogress.ProgressWheel
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.progress_bar_default.*
import javax.inject.Inject

class SignInActivity : BaseActivity(), SignInView {

    @Inject
    lateinit var presenter: SignInPresenter

    override var layoutId: Int = R.layout.activity_sign_in

    override fun setupInjection(applicationComponent: ApplicationComponent) {
        applicationComponent.plus(SignInActivityModule(this))
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

    override fun showSignInLoading() {
        progress_wheel.visible()
        button_sign_in.gone()
    }

    override fun hideSignInLoading() {
        progress_wheel.gone()
        button_sign_in.visible()
    }

    @OnClick(R.id.button_sign_in)
    fun onClick() {
        presenter.signIn(
                input_name.text(),
                input_surname.text(),
                input_email.text(),
                input_password.text(),
                input_repeat_password.text())
    }

}
