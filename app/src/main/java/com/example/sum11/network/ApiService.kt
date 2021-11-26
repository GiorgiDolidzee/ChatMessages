package com.example.sum11.network

import com.example.sum11.model.Users
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("80d25aee-d9a6-4e9c-b1d1-80d2a7c979bf")
    suspend fun getUsers() : Response<Users>

}