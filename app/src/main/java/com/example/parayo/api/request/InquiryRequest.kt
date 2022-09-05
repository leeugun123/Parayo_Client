package com.example.parayo.api.request

data class InquiryRequest(
    val type : String,  //질문 , 답
    val inquiryId : Long?,
    val productId : Long,
    val content : String?
){
    val isContentEmpty = content.isNullOrEmpty()
}
