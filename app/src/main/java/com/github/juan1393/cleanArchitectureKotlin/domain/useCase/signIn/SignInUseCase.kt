package com.github.juan1393.cleanArchitectureKotlin.domain.useCase.signIn

import com.github.juan1393.cleanArchitectureKotlin.data.exception.MapperException
import com.github.juan1393.cleanArchitectureKotlin.data.exception.NetworkConnectionException
import com.github.juan1393.cleanArchitectureKotlin.data.exception.NetworkServiceException
import com.github.juan1393.cleanArchitectureKotlin.data.exception.UserAlreadyExistsException
import com.github.juan1393.cleanArchitectureKotlin.domain.model.User
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.base.BaseUseCase
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.executor.MainThread
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.executor.UseCaseExecutor
import com.github.juan1393.cleanArchitectureKotlin.repository.UserRepository


class SignInUseCase(private val userRepository: UserRepository,
                    executor: UseCaseExecutor, mainThread: MainThread) :
        BaseUseCase<SignInRequest, SignInResponse>(executor, mainThread) {

    override fun run() {
        try {
            request!!.securePassword()
            val response = userRepository.signIn(request!!)
            notifyUserSignedIn(response.data!!)
        } catch (e: NetworkConnectionException) {
            notifyNetworkConnectionError()
        } catch (e: NetworkServiceException) {
            notifyNetworkServiceError()
        } catch (e: UserAlreadyExistsException) {
            notifyUserAlreadyExists()
        } catch (e: java.security.NoSuchAlgorithmException) {
            notifyUnknownError()
        } catch (e: MapperException) {
            notifyUnknownError()
        }

    }

    private fun notifyUserSignedIn(user: User) {
        mainThread.post(Runnable { response!!.onUserSignedIn(user) })
    }

    private fun notifyUserAlreadyExists() {
        mainThread.post(Runnable { response!!.onUserAlreadyExists() })
    }
}
