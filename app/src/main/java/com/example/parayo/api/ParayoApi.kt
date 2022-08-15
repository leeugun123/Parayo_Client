package com.example.parayo.api

import com.example.parayo.api.response.ApiResponse
import com.example.parayo.api.response.SigninResponse
import com.example.parayo.request.SigninRequest
import com.example.parayo.request.SignupRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ParayoApi {

    //1
    @GET("/api/v1/hello")// get메소드로 해당 URL를 호출
    suspend fun hello(): ApiResponse<String> //2

    @POST("/api/v1/users")
    suspend fun signup(@Body signupRequest: SignupRequest)
        : ApiResponse<Void>

    @POST("/api/v1/signin")
    suspend fun signin(@Body signinRequest: SigninRequest)
        : ApiResponse<SigninResponse>

    companion object{

        //2
        val instance = ApiGenerator()
            .generate(ParayoApi::class.java)

    }
}