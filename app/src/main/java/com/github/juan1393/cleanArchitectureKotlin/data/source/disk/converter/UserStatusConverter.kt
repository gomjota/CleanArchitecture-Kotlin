package com.github.juan1393.cleanArchitectureKotlin.data.source.disk.converter

import android.arch.persistence.room.TypeConverter
import com.github.juan1393.cleanArchitectureKotlin.domain.model.User


class UserStatusConverter {

    @TypeConverter
    fun fromTypeToValue(status: User.Status): String? = status.toString()

    @TypeConverter
    fun fromValueToType(value: String): User.Status? = User.Status.valueOf(value)
}