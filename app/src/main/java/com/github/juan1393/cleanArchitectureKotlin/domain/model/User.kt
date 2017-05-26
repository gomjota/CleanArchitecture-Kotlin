package com.github.juan1393.cleanArchitectureKotlin.domain.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity
class User(@PrimaryKey var id: String,
           var name: String,
           var surname: String,
           var photo: String,
           var email: String,
           var password: String? = null,
           var status: Status) {

    enum class Status(val status: String) {
        PENDING("pending"),
        DISABLED("disabled"),
        ENABLED("enabled");

        companion object {
            @Throws(IllegalArgumentException::class)
            fun from(search: String): Status = requireNotNull(Status.values().find { it.status == search }) {
                throw IllegalArgumentException()
            }
        }
    }
}