package com.github.juan1393.cleanArchitectureKotlin.data.repository

import com.github.juan1393.cleanArchitectureKotlin.data.entity.UserEntity
import com.github.juan1393.cleanArchitectureKotlin.data.exception.UserNotFoundException
import com.github.juan1393.cleanArchitectureKotlin.data.mapper.NetworkAuthenticationResponseToUserEntityMapper
import com.github.juan1393.cleanArchitectureKotlin.data.mapper.UserEntityDataMapper
import com.github.juan1393.cleanArchitectureKotlin.data.source.cache.CacheDataSource
import com.github.juan1393.cleanArchitectureKotlin.data.source.disk.DiskDataSource
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.NetworkDataSource
import com.github.juan1393.cleanArchitectureKotlin.domain.model.User
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.base.Response
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.login.LoginRequest
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.recoverPassword.RecoverPasswordRequest
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.signUp.SignUpRequest


class UserRepository(private val networkDataSource: NetworkDataSource,
                     private val diskDataSource: DiskDataSource,
                     private val cacheDataSource: CacheDataSource,
                     private val userEntityDataMapper: UserEntityDataMapper) {

    fun getCurrentUser(): Response<User> {
        var user = cacheDataSource.user
        if (user == null) user = diskDataSource.getUser()
        if (user == null) throw UserNotFoundException()
        return Response(userEntityDataMapper.map(user))
    }

    fun login(request: LoginRequest): Response<User> {
        val response = networkDataSource.login(request)
        val user = response.data!!
        saveUser(user)
        return Response(userEntityDataMapper.map(user))
    }

    fun signUp(request: SignUpRequest): Response<User> {
        val response = networkDataSource.signUp(request)
        val user = response.data!!
        saveUser(user)
        return Response(userEntityDataMapper.map(user))
    }

    private fun saveUser(user: UserEntity?) {
        user?.let {
            cacheDataSource.user = user
            diskDataSource.insertUser(it)
        }
    }

    fun recoverPassword(request: RecoverPasswordRequest): Response<Void>
            = networkDataSource.recoverPassword(request)

    fun signOut() {
        diskDataSource.deleteAllTables()
    }
}