package com.github.juan1393.cleanArchitectureKotlin.data.source.network


import com.github.juan1393.cleanArchitectureKotlin.data.entity.ComicEntity
import com.github.juan1393.cleanArchitectureKotlin.data.entity.UserEntity
import com.github.juan1393.cleanArchitectureKotlin.data.exception.*
import com.github.juan1393.cleanArchitectureKotlin.data.mapper.NetworkAuthenticationResponseToUserEntityMapper
import com.github.juan1393.cleanArchitectureKotlin.data.mapper.NetworkGetComicsResponseToComicEntityMapper
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.manager.NetworkClientManager
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.model.NetworkError
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.request.base.auth.NetworkUserAuthenticationResponse
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.request.getComics.NetworkGetComicsRequest
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.request.getComics.NetworkGetComicsResponse
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.request.login.NetworkLoginRequest
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.request.recoverPassword.NetworkRecoverPasswordRequest
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.request.signUp.NetworkSignUpRequest
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.base.Response
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.getComics.GetComicsRequest
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.login.LoginRequest
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.recoverPassword.RecoverPasswordRequest
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.signUp.SignUpRequest

class NetworkDataSource(private var networkClientManager: NetworkClientManager,
                        private val networkAuthenticationResponseToUserEntityMapper: NetworkAuthenticationResponseToUserEntityMapper,
                        private val networkGetComicsResponseToComicEntityMapper: NetworkGetComicsResponseToComicEntityMapper) {

    fun login(request: LoginRequest): Response<UserEntity> {
        val networkResponse = NetworkLoginRequest(request, networkClientManager).run()

        if (!networkResponse.isSuccessful) {
            if (networkResponse.error?.error
                    .equals(NetworkError.Code.INCORRECT_AUTHENTICATION_CREDENTIALS.toString())) {
                throw IncorrectAuthenticationCredentialsException()
            }
            throw NetworkServiceException()
        }

        return Response(networkAuthenticationResponseToUserEntityMapper.map(networkResponse.data!!))
    }

    fun signUp(request: SignUpRequest): Response<UserEntity> {
        val networkResponse = NetworkSignUpRequest(request, networkClientManager).run()

        if (!networkResponse.isSuccessful) {
            if (networkResponse.error?.error
                    .equals(NetworkError.Code.USER_ALREADY_EXISTS.toString())) {
                throw UserAlreadyExistsException()
            }
            throw NetworkServiceException()
        }

        return Response(networkAuthenticationResponseToUserEntityMapper.map(networkResponse.data!!))
    }

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

    fun getComics(request: GetComicsRequest): Response<List<ComicEntity>> {
        val networkResponse = NetworkGetComicsRequest(request, networkClientManager).run()

        if (!networkResponse.isSuccessful) {
            throw NetworkServiceException()
        }

        return Response(networkGetComicsResponseToComicEntityMapper.map(networkResponse.data!!))
    }
}
