package com.github.juan1393.cleanArchitectureKotlin.domain.useCase.getComics

import com.github.juan1393.cleanArchitectureKotlin.domain.model.Comic
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.base.BaseResponse


interface GetComicsResponse : BaseResponse {

    fun onComicsReceived(comics: List<Comic>)
}