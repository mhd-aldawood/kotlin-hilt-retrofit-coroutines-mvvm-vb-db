package com.example.hilt.data.api

import com.mindorks.framework.mvvm.data.api.ApiService
import com.example.hilt.data.model.User
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getUsers(): Response<List<User>> = apiService.getUsers()

}