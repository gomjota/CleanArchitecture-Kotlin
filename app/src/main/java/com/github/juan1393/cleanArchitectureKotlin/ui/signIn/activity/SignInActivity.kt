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
import javax.inject.Inject

class SignInActivity : BaseActivity(), SignInView {

    @Inject
    lateinit var presenter: SignInPresenter

    @BindView(R.id.input_name)
    lateinit var inputName: EditText
    @BindView(R.id.input_surname)
    lateinit var inputSurname: EditText
    @BindView(R.id.input_email)
    lateinit var inputEmail: EditText
    @BindView(R.id.input_password)
    lateinit var inputPassword: EditText
    @BindView(R.id.input_repeat_password)
    lateinit var inputRepeatPassword: EditText
    @BindView(R.id.button_sign_in)
    lateinit var buttonSignIn: Button
    @BindView(R.id.progress_wheel)
    lateinit var loadingSignIn: ProgressWheel

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
        loadingSignIn.visible()
        buttonSignIn.gone()
    }

    override fun hideSignInLoading() {
        loadingSignIn.gone()
        buttonSignIn.visible()
    }

    @OnClick(R.id.button_sign_in)
    fun onViewClicked() {
        presenter.signIn(
                inputName.text(),
                inputSurname.text(),
                inputEmail.text(),
                inputPassword.text(),
                inputRepeatPassword.text())
    }

}
