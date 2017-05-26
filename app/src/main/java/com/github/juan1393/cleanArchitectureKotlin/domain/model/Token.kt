package com.github.juan1393.cleanArchitectureKotlin.domain.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Token(@PrimaryKey var token: String)