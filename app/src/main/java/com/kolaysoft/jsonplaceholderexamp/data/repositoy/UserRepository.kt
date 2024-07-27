package com.kolaysoft.jsonplaceholderexamp.data.repositoy

import com.kolaysoft.jsonplaceholderexamp.data.model.UserModel

interface UserRepository {
    suspend fun getUsers(): List<UserModel>
}