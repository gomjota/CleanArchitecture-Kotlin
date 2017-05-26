package com.github.juan1393.cleanArchitectureKotlin.data.source.network.request.base.auth


open class NetworkUserAuthenticationResponse(val id: String,
                                             val name: String,
                                             val surname: String,
                                             val photo: String,
                                             val email: String,
                                             val token: String,
                                             val status: String)