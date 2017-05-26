package com.github.juan1393.cleanArchitectureKotlin.data.source.disk

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.github.juan1393.cleanArchitectureKotlin.App
import com.github.juan1393.cleanArchitectureKotlin.data.source.disk.converter.UserStatusConverter
import com.github.juan1393.cleanArchitectureKotlin.data.source.disk.dao.TokenDao
import com.github.juan1393.cleanArchitectureKotlin.data.source.disk.dao.UserDao
import com.github.juan1393.cleanArchitectureKotlin.domain.model.Token
import com.github.juan1393.cleanArchitectureKotlin.domain.model.User

@Database(entities = arrayOf(
        User::class,
        Token::class), version = 1)
@TypeConverters(UserStatusConverter::class)
abstract class Database : RoomDatabase() {

    abstract fun userModel(): UserDao
    abstract fun tokenModel(): TokenDao

    companion object {
        val DATABASE_NAME: String = "app_db"

        fun createInstance(appContext: App):
                com.github.juan1393.cleanArchitectureKotlin.data.source.disk.Database
                = Room.databaseBuilder(appContext,
                com.github.juan1393.cleanArchitectureKotlin.data.source.disk.Database::class.java, DATABASE_NAME)
                .build()
    }
}
