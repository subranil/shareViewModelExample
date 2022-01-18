package com.subranil.sharedviewmodelexample.repository

import com.subranil.sharedviewmodelexample.network.AuthApi

class AuthRepository(
    private val api: AuthApi,
) : BaseRepository(api) {

    suspend fun login(
        email: String,
        password: String
    ) = safeApiCall {
        api.login(email, password)
    }

}