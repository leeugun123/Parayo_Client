package com.example.parayo.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiGenerator {

    fun <T> generate(api: Class<T>) : T = Retrofit.Builder()
        .baseUrl(HOST)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient())
        .build()
        .create(api)


    //Retrofit과 연계할 HTTP 통신 객체를 생성하는 함수
    private fun httpClient() =

        OkHttpClient.Builder().apply {
            addInterceptor(httpLoggingIntercepter())
        }.build()

    //API의 응답 결과를 로그로 확인하기 위해 별도로 HTTP body를 로깅함
    private fun httpLoggingIntercepter() =

        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    companion object{
        const val HOST = "http://10.0.2.2:8080"
    }

}