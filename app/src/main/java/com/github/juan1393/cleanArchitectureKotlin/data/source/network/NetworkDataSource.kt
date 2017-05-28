package com.github.juan1393.cleanArchitectureKotlin.data.source.network


import com.github.juan1393.cleanArchitectureKotlin.data.exception.*
import com.github.juan1393.cleanArchitectureKotlin.data.mapper.NetworkAuthenticationResponseToUserMapper
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.manager.NetworkClientManager
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.model.NetworkError
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.request.login.NetworkLoginRequest
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.request.recoverPassword.NetworkRecoverPasswordRequest
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.request.signIn.NetworkSignInRequest
import com.github.juan1393.cleanArchitectureKotlin.domain.model.User
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.base.Response
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.login.LoginRequest
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.recoverPassword.RecoverPasswordRequest
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.signIn.SignInRequest

class NetworkDataSource(var networkClientManager: NetworkClientManager) {

    @Throws(NetworkConnectionException::class, NetworkServiceException::class, IncorrectAuthenticationCredentialsException::class)
    fun login(request: LoginRequest): Response<User> {
        val networkResponse = NetworkLoginRequest(request, networkClientManager).run()

        if (!networkResponse.isSuccessful) {
            if (networkResponse.error?.error
                    .equals(NetworkError.Code.INCORRECT_AUTHENTICATION_CREDENTIALS.toString())) {
                throw IncorrectAuthenticationCredentialsException()
            }
            throw NetworkServiceException()
        }

        return Response(NetworkAuthenticationResponseToUserMapper().map(networkResponse.data!!))
    }

    @Throws(NetworkConnectionException::class, NetworkServiceException::class, UserAlreadyExistsException::class)
    fun signIn(request: SignInRequest): Response<User> {
        val networkResponse = NetworkSignInRequest(request, networkClientManager).run()

        if (!networkResponse.isSuccessful) {
            if (networkResponse.error?.error
                    .equals(NetworkError.Code.USER_ALREADY_EXISTS.toString())) {
                throw UserAlreadyExistsException()
            }
            throw NetworkServiceException()
        }

        return Response(NetworkAuthenticationResponseToUserMapper().map(networkResponse.data!!))
    }

    @Throws(NetworkConnectionException::class, NetworkServiceException::class, UserNotFoundException::class)
    fun recoverPassword(request: RecoverPasswordRequest): Response<Void> {
        val networkResponse = NetworkRecoverPasswordRequest(request, networkClientManager).run()

        if (!networkResponse.isSuccessful) {
            if (networkResponse.error?.error
                    .equals(NetworkError.Code.USER_NOT_FOUND.toString())) {
                throw UserNotFoundException()
            }
            throw NetworkServiceException()
        }

        return Response()
    }
}
