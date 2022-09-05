package com.example.parayo.api

import com.example.parayo.api.request.InquiryRequest
import com.example.parayo.api.request.ProductRegistrationRequest
import com.example.parayo.api.response.*
import com.example.parayo.request.SigninRequest
import com.example.parayo.request.SignupRequest
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

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

    @Multipart
    @POST("/api/v1/product_images")
    suspend fun uploadProductImages(
        @Part images: MultipartBody.Part
    ): ApiResponse<ProductImageUploadResponse>

    @POST("/api/v1/products")
    suspend fun registerProduct(
        @Body request: ProductRegistrationRequest
    ): ApiResponse<Response<Void>>

    @GET("/api/v1/products")
    suspend fun getProducts(
        @Query("productId") productId: Long,
        @Query("categoryId") category : Int,
        @Query("direction") direction : String,
        @Query("keyword") keyword : String? = null
    ) : ApiResponse<List<ProductListItemResponse>>


    @GET("/api/v1/products/{id}")
    suspend fun getProduct(@Path("id") id : Long)
        : ApiResponse<ProductResponse>


    @PUT("/api/v1/users/fcm_token")
    suspend fun updateFcmToken(fcmToken : String)
        : ApiResponse<Response<Void>>

    companion object{

        //2
        val instance = ApiGenerator()
            .generate(ParayoApi::class.java)

    }

    @GET("/api/v1/inquiries")
    suspend fun getInquiries(
        @Query("inquiryId") inquiryId: Long,
        @Query("productId") productId: Long? = null,
        @Query("requestUserId") requestUserId : Long? = null,
        @Query("productOwnerId") productOwnerId: Long? = null,
        @Query("direction") direction : String
    ) : ApiResponse<List<InquiryResponse>>

    @POST("/api/v1/inquiries")
    suspend fun registerInquiry(
        @Body request : InquiryRequest
    ): ApiResponse<Response<Void>>

}