package com.example.hilt.data.repo

import com.example.hilt.data.api.ApiHelper
import com.example.hilt.data.model.reuqest.User
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getUsers() =  apiHelper.getUsers()
    suspend fun userLogin(user: User)=apiHelper.userLogin(user)
    suspend fun getProducts()=apiHelper.getProducts()

}