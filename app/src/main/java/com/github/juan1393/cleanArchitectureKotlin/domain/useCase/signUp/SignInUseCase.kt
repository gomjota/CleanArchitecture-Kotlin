package com.github.juan1393.cleanArchitectureKotlin.domain.useCase.signUp

import com.github.juan1393.cleanArchitectureKotlin.data.exception.MapperException
import com.github.juan1393.cleanArchitectureKotlin.data.exception.NetworkConnectionException
import com.github.juan1393.cleanArchitectureKotlin.data.exception.NetworkServiceException
import com.github.juan1393.cleanArchitectureKotlin.data.exception.UserAlreadyExistsException
import com.github.juan1393.cleanArchitectureKotlin.domain.model.User
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.base.BaseUseCase
import com.github.juan1393.cleanArchitectureKotlin.app.ui.base.mainThread.MainThread
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.executor.UseCaseExecutor
import com.github.juan1393.cleanArchitectureKotlin.data.repository.UserRepository


class SignUpUseCase(private val userRepository: UserRepository,
                    executor: UseCaseExecutor, mainThread: MainThread) :
        BaseUseCase<SignUpRequest, SignUpResponse>(executor, mainThread) {

    override fun run() {
        try {
            request!!.securePassword()
            val response = userRepository.signUp(request!!)
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
