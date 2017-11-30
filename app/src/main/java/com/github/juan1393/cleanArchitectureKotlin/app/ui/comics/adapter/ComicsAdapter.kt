package com.github.juan1393.cleanArchitectureKotlin.app.ui.comics.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.juan1393.cleanArchitectureKotlin.R
import com.github.juan1393.cleanArchitectureKotlin.app.ui.base.loadUrl
import com.github.juan1393.cleanArchitectureKotlin.app.ui.comics.adapter.displayModel.ComicsDisplayModel
import kotlinx.android.synthetic.main.item_comic.view.*


class ComicsAdapter(private val comics: ComicsDisplayModel,
                    private val listener: (Int) -> Unit) : RecyclerView.Adapter<ComicsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_comic, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comic = comics.get(position)
        holder.bind(comic, position, listener)
    }

    override fun getItemCount(): Int = comics.size()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(comic: ComicsDisplayModel.ComicDisplayModel, position: Int, listener: (Int) -> Unit) = with(itemView) {
            comic_title.text = comic.title
            comic_image.loadUrl(comic.thumbnail)
            setOnClickListener { listener(position) }
        }
    }
}