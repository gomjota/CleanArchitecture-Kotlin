package com.github.juan1393.cleanArchitectureKotlin.data.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "token")
class TokenEntity(@PrimaryKey var token: String)