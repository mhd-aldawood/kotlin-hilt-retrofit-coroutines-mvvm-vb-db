package com.example.hilt.data.api

import com.example.hilt.data.model.responde.Product
import com.mindorks.framework.mvvm.data.api.ApiService
import com.example.hilt.data.model.reuqest.User
import com.example.hilt.data.model.responde.Token
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getUsers(): Response<List<User>> = apiService.getUsers()

    override suspend fun userLogin(user: User): Response<Token> =apiService.userLogin(user)
    override suspend fun getProducts(): Response<List<Product>> =apiService.getProducts()
//    override suspend fun getProducts(): Response<ProductList> =apiService.getProducts()

}