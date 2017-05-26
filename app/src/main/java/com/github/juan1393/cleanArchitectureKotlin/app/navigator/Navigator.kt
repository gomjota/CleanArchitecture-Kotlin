package com.github.juan1393.cleanArchitectureKotlin.app.navigator

import android.content.Intent
import com.github.juan1393.cleanArchitectureKotlin.ui.base.BaseActivity
import com.github.juan1393.cleanArchitectureKotlin.ui.login.activity.LoginActivity
import com.github.juan1393.cleanArchitectureKotlin.ui.main.activity.MainActivity
import com.github.juan1393.cleanArchitectureKotlin.ui.recoverPassword.activity.RecoverPasswordActivity
import com.github.juan1393.cleanArchitectureKotlin.ui.signIn.activity.SignInActivity
import com.github.juan1393.cleanArchitectureKotlin.ui.splash.activity.SplashActivity


class Navigator {

    var currentActivity: BaseActivity? = null

    private fun toDefaultActivity(activity: Class<*>) {
        val intent = Intent(currentActivity, activity)
        currentActivity?.startActivity(intent)
    }

    private fun toDefaultActivityForResult(requestCode: Int, activity: Class<*>) {
        val intent = Intent(currentActivity, activity)
        currentActivity?.startActivityForResult(intent, requestCode)
    }

    private fun toDefaultActivityCleaningStack(activity: Class<*>) {
        val intent = Intent(currentActivity, activity)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        currentActivity?.startActivity(intent)
    }

    fun toSplash() {
        toDefaultActivityCleaningStack(SplashActivity::class.java)
    }

    fun toLogin() {
        toDefaultActivity(LoginActivity::class.java)
    }

    fun toMain() {
        toDefaultActivityCleaningStack(MainActivity::class.java)
    }

    fun toSignIn() {
        toDefaultActivity(SignInActivity::class.java)
    }

    fun toRecoverPassword() {
        toDefaultActivity(RecoverPasswordActivity::class.java)
    }

    fun toLoginCleaningStack() {
        toDefaultActivityCleaningStack(LoginActivity::class.java)
    }

    fun finishActivity() {
        currentActivity?.finish()
    }
}
