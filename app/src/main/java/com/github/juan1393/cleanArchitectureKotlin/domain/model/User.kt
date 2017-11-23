package com.github.juan1393.cleanArchitectureKotlin.domain.model

class User(var id: String,
           var name: String,
           var surname: String,
           var photo: String,
           var email: String,
           var password: String? = null)