package com.github.juan1393.cleanArchitectureKotlin.app.ui.base

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator


fun AppCompatActivity.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Fragment.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(activity, message, duration).show()
}

fun EditText.text(): String = this.text.toString()

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun ImageView.loadUrl(url: String) {
    Picasso.with(this.context).load(url).into(this)
}

inline fun ImageView.loadUrl(url: String, callback: KCallback.() -> Unit) {
    Picasso.with(this.context).load(url).intoWithCallback(this, callback)
}

inline fun RequestCreator.intoWithCallback(target: ImageView, callback: KCallback.() -> Unit) {
    this.into(target, KCallback().apply(callback))
}

class KCallback : Callback {

    private var onSuccess: (() -> Unit)? = null
    private var onError: (() -> Unit)? = null

    override fun onSuccess() {
        onSuccess?.invoke()
    }

    override fun onError() {
        onError?.invoke()
    }

    fun onSuccess(function: () -> Unit) {
        this.onSuccess = function
    }

    fun onError(function: () -> Unit) {
        this.onError = function
    }
}

