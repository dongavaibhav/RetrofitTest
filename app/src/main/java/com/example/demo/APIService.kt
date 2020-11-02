package com.example.demo

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface APIService {
    @POST("/create")
    @FormUrlEncoded
    fun savePost(@Field("name") name: String?,
                 @Field("salary") salary: String?,
                 @Field("age") age: String?): Call<Post?>
}