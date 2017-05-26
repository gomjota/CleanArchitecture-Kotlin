package com.github.juan1393.cleanArchitectureKotlin.data.mapper

import com.github.juan1393.cleanArchitectureKotlin.data.source.network.request.base.auth.NetworkUserAuthenticationResponse
import com.github.juan1393.cleanArchitectureKotlin.data.exception.MapperException
import com.github.juan1393.cleanArchitectureKotlin.domain.model.User


class NetworkAuthenticationResponseToUserMapper : Mapper<NetworkUserAuthenticationResponse, User> {

    @Throws(MapperException::class)
    override fun map(input: NetworkUserAuthenticationResponse): User {
        val user = User(
                id = getId(input),
                name = getName(input),
                surname = getSurname(input),
                photo = getPhoto(input),
                email = getEmail(input),
                status = getStatus(input))
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

    @Throws(MapperException::class)
    private fun getStatus(input: NetworkUserAuthenticationResponse): User.Status {
        try {
            return User.Status.from(input.status)
        } catch (e: IllegalArgumentException) {
            throw MapperException()
        }
    }
}
