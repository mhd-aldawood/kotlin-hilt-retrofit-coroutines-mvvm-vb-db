package com.example.hilt.data.model.responde

import com.squareup.moshi.Json

data class Token(@Json(name="token") var token: String? = null)
