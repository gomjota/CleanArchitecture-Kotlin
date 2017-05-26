package com.github.juan1393.cleanArchitectureKotlin.data.source.disk.dao

import android.arch.persistence.room.*
import com.github.juan1393.cleanArchitectureKotlin.domain.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("DELETE FROM user")
    fun deleteAllUsers()

    @Query("SELECT * FROM user LIMIT 1")
    fun getFirstUser() : User
}