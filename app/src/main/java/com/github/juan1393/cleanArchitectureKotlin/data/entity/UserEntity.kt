package com.github.juan1393.cleanArchitectureKotlin.data.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "user")
class UserEntity(@PrimaryKey var id: String,
                 var name: String,
                 var surname: String,
                 var photo: String,
                 var email: String,
                 var password: String? = null)