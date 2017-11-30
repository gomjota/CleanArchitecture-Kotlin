package com.github.juan1393.cleanArchitectureKotlin.domain.useCase.login

import com.github.juan1393.cleanArchitectureKotlin.data.exception.IncorrectAuthenticationCredentialsException
import com.github.juan1393.cleanArchitectureKotlin.data.exception.MapperException
import com.github.juan1393.cleanArchitectureKotlin.data.exception.NetworkConnectionException
import com.github.juan1393.cleanArchitectureKotlin.data.exception.NetworkServiceException
import com.github.juan1393.cleanArchitectureKotlin.domain.model.User
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.base.BaseUseCase
import com.github.juan1393.cleanArchitectureKotlin.app.ui.base.mainThread.MainThread
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.executor.UseCaseExecutor
import com.github.juan1393.cleanArchitectureKotlin.data.repository.UserRepository
import java.security.NoSuchAlgorithmException


class LoginUseCase(private val userRepository: UserRepository,
                   executor: UseCaseExecutor, mainThread: MainThread) :
        BaseUseCase<LoginRequest, LoginResponse>(executor, mainThread) {

    override fun run() {
        try {
            request!!.securePassword()
            val response = userRepository.login(request!!)
            notifyUserLoggedIn(response.data!!)
        } catch (e: NetworkConnectionException) {
            notifyNetworkConnectionError()
        } catch (e: NetworkServiceException) {
            notifyNetworkServiceError()
        } catch (e: IncorrectAuthenticationCredentialsException) {
            notifyIncorrectLoginUserData()
        } catch (e: NoSuchAlgorithmException) {
            notifyUnknownError()
        } catch (e: MapperException) {
            notifyUnknownError()
        }

    }

    private fun notifyUserLoggedIn(user: User) {
        mainThread.post(Runnable { response!!.onUserLoggedIn(user) })
    }

    private fun notifyIncorrectLoginUserData() {
        mainThread.post(Runnable { response!!.onIncorrectLoginUserData() })
    }
}
