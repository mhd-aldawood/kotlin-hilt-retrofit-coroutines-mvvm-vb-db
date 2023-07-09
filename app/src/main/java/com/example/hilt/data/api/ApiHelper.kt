package com.example.hilt.data.api

import com.example.hilt.data.model.responde.Product
import com.example.hilt.data.model.reuqest.User
import com.example.hilt.data.model.responde.Token
import retrofit2.Response

interface ApiHelper {

    suspend fun getUsers(): Response<List<User>>
    suspend fun userLogin(user: User): Response<Token>
    suspend fun getProducts(): Response<List<Product>>
}