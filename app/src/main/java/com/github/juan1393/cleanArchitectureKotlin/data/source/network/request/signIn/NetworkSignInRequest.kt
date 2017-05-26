package com.github.juan1393.cleanArchitectureKotlin.data.source.network.request.signIn


import com.github.juan1393.cleanArchitectureKotlin.data.source.network.model.body.NetworkSignInBody
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.request.base.auth.NetworkUserAuthenticationResponse
import com.github.juan1393.cleanArchitectureKotlin.data.exception.NetworkConnectionException
import com.github.juan1393.cleanArchitectureKotlin.data.exception.NetworkServiceException
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.manager.NetworkClientManager
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.model.NetworkResponse
import com.github.juan1393.cleanArchitectureKotlin.data.source.network.request.base.NetworkRequest
import com.github.juan1393.cleanArchitectureKotlin.domain.useCase.signIn.SignInRequest

class NetworkSignInRequest(private val signInRequest: SignInRequest,
                           var networkClientManager: NetworkClientManager) :
        NetworkRequest<NetworkUserAuthenticationResponse>(networkClientManager) {

    @Throws(NetworkConnectionException::class, NetworkServiceException::class)
    override fun run(): NetworkResponse<NetworkUserAuthenticationResponse> {
        val networkSignInBody = NetworkSignInBody(
                signInRequest.name,
                signInRequest.surname,
                signInRequest.email,
                signInRequest.password)

        val call = API.signIn(networkSignInBody)
        val response = execute(call)

        if (response.isSuccessful) {
            networkClientManager.updateToken(response.data!!.token)
        }

        return response
    }
}
