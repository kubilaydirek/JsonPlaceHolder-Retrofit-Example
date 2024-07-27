package com.kolaysoft.jsonplaceholderexamp.data.service

import com.kolaysoft.jsonplaceholderexamp.data.model.UserModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): Response<List<UserModel>>
}