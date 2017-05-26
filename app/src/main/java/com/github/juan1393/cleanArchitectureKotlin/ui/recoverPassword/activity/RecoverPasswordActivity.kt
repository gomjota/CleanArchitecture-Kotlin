package com.github.juan1393.cleanArchitectureKotlin.ui.recoverPassword.activity

import android.view.View
import android.widget.Button
import android.widget.EditText
import butterknife.BindView
import butterknife.OnClick
import com.github.juan1393.cleanArchitectureKotlin.R
import com.github.juan1393.cleanArchitectureKotlin.app.di.component.ApplicationComponent
import com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.recoverPassword.RecoverPasswordActivityModule
import com.github.juan1393.cleanArchitectureKotlin.ui.base.BaseActivity
import com.github.juan1393.cleanArchitectureKotlin.ui.base.Presenter
import com.github.juan1393.cleanArchitectureKotlin.ui.base.toast
import com.github.juan1393.cleanArchitectureKotlin.ui.recoverPassword.presenter.RecoverPasswordPresenter
import com.pnikosis.materialishprogress.ProgressWheel
import javax.inject.Inject


class RecoverPasswordActivity : BaseActivity(), RecoverPasswordView {

    @Inject
    lateinit var presenter: RecoverPasswordPresenter

    @BindView(R.id.input_email)
    lateinit var inputEmail: EditText
    @BindView(R.id.button_recover_password)
    lateinit var buttonRecoverPassword: Button
    @BindView(R.id.progress_wheel)
    lateinit var loadingRecoverPassword: ProgressWheel

    override var layoutId: Int = R.layout.activity_recover_password

    override fun getPresenter(): Presenter<*> = presenter

    override fun setupInjection(applicationComponent: ApplicationComponent) {
        applicationComponent.plus(RecoverPasswordActivityModule(this))
                .injectTo(this)
    }

    override fun showIncorrectEmailFormatError() {
        toast(getString(R.string.recover_password_error_email_format))
    }

    override fun showUserNotFoundError() {
        toast(getString(R.string.recover_password_error_user_not_found))
    }

    override fun showRecoverPasswordLoading() {
        loadingRecoverPassword.visibility = View.VISIBLE
        buttonRecoverPassword.visibility = View.GONE
    }

    override fun hideRecoverPasswordLoading() {
        loadingRecoverPassword.visibility = View.GONE
        buttonRecoverPassword.visibility = View.VISIBLE
    }

    @OnClick(R.id.button_recover_password)
    fun onViewClicked(view: View) {
        when (view.id) {
            R.id.button_recover_password -> presenter.recoverPassword(inputEmail.text.toString())
        }
    }
}