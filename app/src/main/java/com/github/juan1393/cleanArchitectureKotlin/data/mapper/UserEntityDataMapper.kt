package com.github.juan1393.cleanArchitectureKotlin.data.mapper

import com.github.juan1393.cleanArchitectureKotlin.data.entity.UserEntity
import com.github.juan1393.cleanArchitectureKotlin.domain.model.User


class UserEntityDataMapper : Mapper<UserEntity, User> {

    override fun map(input: UserEntity): User =
            User(
                    getId(input),
                    getName(input),
                    getSurname(input),
                    getPhoto(input),
                    getEmail(input),
                    getPassword(input))

    private fun getId(input: UserEntity) = input.id

    private fun getName(input: UserEntity) = input.name

    private fun getSurname(input: UserEntity) = input.surname

    private fun getPhoto(input: UserEntity) = input.photo

    private fun getEmail(input: UserEntity) = input.email

    private fun getPassword(input: UserEntity) = input.password
}