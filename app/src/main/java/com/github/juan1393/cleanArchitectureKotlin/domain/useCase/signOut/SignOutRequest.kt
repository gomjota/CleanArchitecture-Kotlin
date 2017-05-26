package com.github.juan1393.cleanArchitectureKotlin.domain.useCase.signOut

import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.base.BaseRequest


class SignOutRequest: BaseRequest() {

    override fun validate(): Boolean {
        return true
    }
}