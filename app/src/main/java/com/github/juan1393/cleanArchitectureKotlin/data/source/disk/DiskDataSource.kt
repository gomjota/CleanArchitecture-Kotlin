package com.github.juan1393.cleanArchitectureKotlin.data.source.disk

import com.github.juan1393.cleanArchitectureKotlin.App
import com.github.juan1393.cleanArchitectureKotlin.data.entity.TokenEntity
import com.github.juan1393.cleanArchitectureKotlin.data.entity.UserEntity

class DiskDataSource(appContext: App) {

    companion object {
        var database: Database? = null
    }

    init {
        database = Database.createInstance(appContext)
    }

    fun insertUser(user: UserEntity) = database?.userModel()?.insertUser(user)

    fun deleteAllUsers() = database?.userModel()?.deleteAllUsers()

    fun deleteUser(user: UserEntity) = database?.userModel()?.deleteUser(user)

    fun getUser() = database?.userModel()?.getFirstUser()

    fun insertToken(token: TokenEntity) = database?.tokenModel()?.insertToken(token)

    fun deleteToken(token: TokenEntity) = database?.tokenModel()?.deleteToken(token)

    fun deleteAllTokens() = database?.tokenModel()?.deleteAllTokens()

    fun getToken() = database?.tokenModel()?.getFirstToken()

    fun deleteAllTables() {
        database?.tokenModel()?.deleteAllTokens()
        database?.userModel()?.deleteAllUsers()
    }
}
