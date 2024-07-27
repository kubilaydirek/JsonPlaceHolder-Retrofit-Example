package com.kolaysoft.jsonplaceholderexamp.data.repositoy

import com.kolaysoft.jsonplaceholderexamp.data.model.UserModel
import com.kolaysoft.jsonplaceholderexamp.data.service.ApiService
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val api: ApiService) : UserRepository {
    override suspend fun getUsers(): List<UserModel> {
        try {
            val response = api.getUsers()
            if (response.code() == 200) run {
                response.body().let {
                    return response.body()!!
                }
            } else {
                return emptyList()
            }
        } catch (e: Exception) {
            return emptyList()
        }
    }

}