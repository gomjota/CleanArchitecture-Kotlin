package com.github.juan1393.cleanArchitectureKotlin.data.mapper

import com.github.juan1393.cleanArchitectureKotlin.data.entity.UserEntity
import com.github.juan1393.cleanArchitectureKotlin.data.exception.MapperException
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.request.base.auth.NetworkUserAuthenticationResponse


class NetworkAuthenticationResponseToUserEntityMapper : Mapper<NetworkUserAuthenticationResponse, UserEntity> {

    @Throws(MapperException::class)
    override fun map(input: NetworkUserAuthenticationResponse): UserEntity {
        val user = UserEntity(
                id = getId(input),
                name = getName(input),
                surname = getSurname(input),
                photo = getPhoto(input),
                email = getEmail(input))
        return user
    }

    private fun getId(input: NetworkUserAuthenticationResponse): String
            = input.id

    private fun getName(input: NetworkUserAuthenticationResponse): String
            = input.name

    private fun getSurname(input: NetworkUserAuthenticationResponse): String
            = input.surname

    private fun getPhoto(input: NetworkUserAuthenticationResponse): String
            = input.photo

    private fun getEmail(input: NetworkUserAuthenticationResponse): String
            = input.email
}
