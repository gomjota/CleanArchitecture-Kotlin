package com.github.juan1393.cleanArchitectureKotlin.domain.useCase.getComics

import com.github.juan1393.cleanArchitectureKotlin.data.exception.IncorrectAuthenticationCredentialsException
import com.github.juan1393.cleanArchitectureKotlin.data.exception.MapperException
import com.github.juan1393.cleanArchitectureKotlin.data.exception.NetworkConnectionException
import com.github.juan1393.cleanArchitectureKotlin.data.exception.NetworkServiceException
import com.github.juan1393.cleanArchitectureKotlin.data.repository.ComicRepository
import com.github.juan1393.cleanArchitectureKotlin.data.repository.UserRepository
import com.github.juan1393.cleanArchitectureKotlin.domain.model.Comic
import com.github.juan1393.cleanArchitectureKotlin.domain.model.User
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.base.BaseUseCase
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.executor.MainThread
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.executor.UseCaseExecutor


class GetComicsUseCase(private val comicRepository: ComicRepository,
                   executor: UseCaseExecutor, mainThread: MainThread) :
        BaseUseCase<GetComicsRequest, GetComicsResponse>(executor, mainThread) {

    override fun run() {
        try {
            val response = comicRepository.getComics(request!!)
            notifyComicsReceived(response.data!!)
        } catch (e: NetworkConnectionException) {
            notifyNetworkConnectionError()
        } catch (e: NetworkServiceException) {
            notifyNetworkServiceError()
        } catch (e: MapperException) {
            notifyUnknownError()
        }

    }

    private fun notifyComicsReceived(comics: List<Comic>) {
        mainThread.post(Runnable { response!!.onComicsReceived(comics) })
    }
}