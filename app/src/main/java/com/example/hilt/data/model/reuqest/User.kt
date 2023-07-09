package com.example.hilt.data.model.reuqest

import com.squareup.moshi.Json

data class User(

    @Json(name = "username") var username: String? = null,
    @Json(name = "password") var password: String? = null

)