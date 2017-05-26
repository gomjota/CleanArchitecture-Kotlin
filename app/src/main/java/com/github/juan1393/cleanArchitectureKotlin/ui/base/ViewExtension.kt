package com.github.juan1393.cleanArchitectureKotlin.ui.base

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast


fun AppCompatActivity.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Fragment.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(activity, message, duration).show()
}