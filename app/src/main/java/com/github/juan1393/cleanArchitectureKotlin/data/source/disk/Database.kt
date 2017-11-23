package com.github.juan1393.cleanArchitectureKotlin.data.source.disk

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import com.github.juan1393.cleanArchitectureKotlin.App
import com.github.juan1393.cleanArchitectureKotlin.data.entity.TokenEntity
import com.github.juan1393.cleanArchitectureKotlin.data.entity.UserEntity
import com.github.juan1393.cleanArchitectureKotlin.data.source.disk.dao.TokenDao
import com.github.juan1393.cleanArchitectureKotlin.data.source.disk.dao.UserDao

@Database(entities = arrayOf(
        UserEntity::class,
        TokenEntity::class), version = 1)
abstract class Database : RoomDatabase() {

    abstract fun userModel(): UserDao
    abstract fun tokenModel(): TokenDao

    companion object {
        private val DATABASE_NAME: String = "app_db"

        fun createInstance(appContext: App):
                com.github.juan1393.cleanArchitectureKotlin.data.source.disk.Database
                = Room.databaseBuilder(appContext,
                com.github.juan1393.cleanArchitectureKotlin.data.source.disk.Database::class.java, DATABASE_NAME)
                .build()
    }
}
