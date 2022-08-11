package com.example.parayo.api

import com.example.parayo.api.response.ApiResponse
import retrofit2.http.GET

interface ParayoApi {

    //1
    @GET("/api/v1/hello")// get메소드로 해당 URL를 호출
    suspend fun hello(): ApiResponse<String> //2

    companion object{

        //2
        val instance = ApiGenerator()
            .generate(ParayoApi::class.java)
    }
}