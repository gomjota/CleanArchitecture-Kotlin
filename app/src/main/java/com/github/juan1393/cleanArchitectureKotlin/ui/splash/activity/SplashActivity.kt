package com.github.juan1393.cleanArchitectureKotlin.ui.splash.activity

import android.os.Bundle
import com.github.juan1393.cleanArchitectureKotlin.R
import com.github.juan1393.cleanArchitectureKotlin.app.di.component.ApplicationComponent
import com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.splash.SplashActivityModule
import com.github.juan1393.cleanArchitectureKotlin.ui.base.BaseActivity
import com.github.juan1393.cleanArchitectureKotlin.ui.base.Presenter
import com.github.juan1393.cleanArchitectureKotlin.ui.splash.presenter.SplashPresenter
import javax.inject.Inject


class SplashActivity : BaseActivity(), SplashView {

    @Inject
    lateinit var presenter: SplashPresenter

    override var layoutId: Int = R.layout.activity_splash

    override fun getPresenter(): Presenter<*> = presenter

    override fun setupInjection(applicationComponent: ApplicationComponent) {
        applicationComponent.plus(SplashActivityModule(this))
                .injectTo(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.loadInitialData()
    }
}