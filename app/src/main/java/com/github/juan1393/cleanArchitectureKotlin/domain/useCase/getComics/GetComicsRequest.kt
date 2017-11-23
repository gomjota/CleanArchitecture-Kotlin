package com.github.juan1393.cleanArchitectureKotlin.domain.useCase.getComics

import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.base.BaseRequest


class GetComicsRequest(val characterId: Int, val maxItems: Int): BaseRequest {

    override fun validate() = true
}