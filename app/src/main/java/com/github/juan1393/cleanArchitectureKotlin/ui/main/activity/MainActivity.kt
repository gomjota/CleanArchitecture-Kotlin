package com.github.juan1393.cleanArchitectureKotlin.ui.main.activity

import android.view.View
import butterknife.OnClick
import com.github.juan1393.cleanArchitectureKotlin.R
import com.github.juan1393.cleanArchitectureKotlin.app.di.component.ApplicationComponent
import com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.main.MainActivityModule
import com.github.juan1393.cleanArchitectureKotlin.ui.base.BaseActivity
import com.github.juan1393.cleanArchitectureKotlin.ui.base.Presenter
import com.github.juan1393.cleanArchitectureKotlin.ui.main.presenter.MainPresenter
import javax.inject.Inject


class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    override var layoutId: Int = R.layout.activity_main

    override fun setupInjection(applicationComponent: ApplicationComponent) {
        applicationComponent.plus(MainActivityModule(this))
                .injectTo(this)
    }

    @OnClick(R.id.button_sign_out)
    fun onViewClicked(view: View) {
        when (view.id) {
            R.id.button_sign_out -> presenter.signOut()
        }
    }
}