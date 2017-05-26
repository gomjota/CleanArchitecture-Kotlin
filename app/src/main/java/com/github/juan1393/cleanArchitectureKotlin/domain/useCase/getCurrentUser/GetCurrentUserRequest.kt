package com.github.juan1393.cleanArchitectureKotlin.domain.useCase.getCurrentUser

import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.base.BaseRequest


class GetCurrentUserRequest: BaseRequest() {

    override fun validate(): Boolean {
        return true
    }
}