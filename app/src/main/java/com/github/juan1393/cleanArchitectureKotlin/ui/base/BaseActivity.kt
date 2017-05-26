package com.github.juan1393.cleanArchitectureKotlin.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import com.github.juan1393.cleanArchitectureKotlin.App
import com.github.juan1393.cleanArchitectureKotlin.app.di.component.ApplicationComponent
import com.github.juan1393.cleanArchitectureKotlin.app.navigator.Navigator
import javax.inject.Inject


abstract class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var navigator: Navigator

    abstract var layoutId: Int

    var basePresenter: Presenter<*>? = null

    abstract fun getPresenter(): Presenter<*>
    abstract fun setupInjection(applicationComponent: ApplicationComponent)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupInjection(App.graph)
        initView()
        navigator.currentActivity = this
        basePresenter = getPresenter()
    }

    private fun initView() {
        setContentView(layoutInflater.inflate(layoutId, null))
        ButterKnife.bind(this)
    }
}
