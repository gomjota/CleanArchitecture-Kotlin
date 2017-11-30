package com.github.juan1393.cleanArchitectureKotlin.app.ui.comics.activity

import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import com.github.juan1393.cleanArchitectureKotlin.R
import com.github.juan1393.cleanArchitectureKotlin.app.di.component.ApplicationComponent
import com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.comics.ComicsActivityModule
import com.github.juan1393.cleanArchitectureKotlin.app.ui.base.BaseActivity
import com.github.juan1393.cleanArchitectureKotlin.app.ui.base.toast
import com.github.juan1393.cleanArchitectureKotlin.app.ui.comics.adapter.ComicsAdapter
import com.github.juan1393.cleanArchitectureKotlin.app.ui.comics.adapter.displayModel.ComicsDisplayModel
import com.github.juan1393.cleanArchitectureKotlin.app.ui.comics.presenter.ComicsPresenter
import kotlinx.android.synthetic.main.activity_comics.*
import kotlinx.android.synthetic.main.progress_bar_default.*
import javax.inject.Inject


class ComicsActivity : BaseActivity(), ComicsView {

    @Inject
    lateinit var presenter: ComicsPresenter

    override var layoutId: Int = R.layout.activity_comics

    override fun setupInjection(applicationComponent: ApplicationComponent) {
        applicationComponent.plus(ComicsActivityModule(this))
                .injectTo(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureComicList()
        presenter.getComics()
    }

    private fun configureComicList() {
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(
                2,
                StaggeredGridLayoutManager.VERTICAL)
        comic_list.layoutManager = staggeredGridLayoutManager
    }

    override fun setDataInComicList(comicsDisplayModel: ComicsDisplayModel) {
        val comicsAdapter = ComicsAdapter(comicsDisplayModel) {
            presenter.onItemOnListClicked(it)
        }
        comic_list.adapter = comicsAdapter
    }

    override fun showProgressWheel() {
        progress_wheel.spin()
    }

    override fun hideProgressWheel() {
        progress_wheel.stopSpinning()
    }

    override fun showCharacterComicsNotFoundError() {
        toast(getString(R.string.error_character_comics_not_found))
    }

    override fun showNetworkConnectionError() {
        toast(getString(R.string.error_network_connection))
    }

    override fun showComicHasNotAllInfoError() {
        toast(getString(R.string.error_comic_not_valid))
    }
}