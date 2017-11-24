package com.github.juan1393.cleanArchitectureKotlin.ui.comicDetail.activity

import android.os.Bundle
import com.github.juan1393.cleanArchitectureKotlin.R
import com.github.juan1393.cleanArchitectureKotlin.app.di.component.ApplicationComponent
import com.github.juan1393.cleanArchitectureKotlin.app.di.subcomponent.comicDetail.ComicDetailActivityModule
import com.github.juan1393.cleanArchitectureKotlin.ui.base.BaseActivity
import com.github.juan1393.cleanArchitectureKotlin.ui.base.loadUrl
import com.github.juan1393.cleanArchitectureKotlin.ui.comicDetail.presenter.ComicDetailPresenter
import com.github.juan1393.cleanArchitectureKotlin.ui.comics.presenter.ComicsPresenter
import kotlinx.android.synthetic.main.activity_comic_detail.*
import kotlinx.android.synthetic.main.content_comic_detail.*
import kotlinx.android.synthetic.main.toolbar_back.*
import javax.inject.Inject


class ComicDetailActivity : BaseActivity(), ComicDetailView {

    @Inject
    lateinit var presenter: ComicDetailPresenter

    override var layoutId: Int = R.layout.activity_comic_detail

    override fun setupInjection(applicationComponent: ApplicationComponent) {
        applicationComponent.plus(ComicDetailActivityModule(this))
                .injectTo(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureToolbar()
        presenter.setIntentParams(intent)
    }

    private fun configureToolbar() {
        toolbar_back.title = ""
        toolbar_back.setOnClickListener { presenter.onToolbarClicked() }
        setSupportActionBar(toolbar_back)
    }

    override fun setHeaderImage(imageUrl: String) {
        comic_detail_image.loadUrl(imageUrl)
    }

    override fun setTitle(title: String) {
        comic_detail_title.text = title
    }

    override fun setDescription(description: String) {
        comic_detail_description.text = description
    }

    override fun setCharacters(characters: String) {
        comic_detail_characters.text = characters
    }

    override fun setCreators(creators: String) {
        comic_detail_creators.text = creators
    }

    override fun setPrice(price: String) {
        comic_detail_price.text = price
    }
}