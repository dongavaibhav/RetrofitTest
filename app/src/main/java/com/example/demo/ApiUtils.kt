package com.example.demo

object ApiUtils {
    const val BASE_URL = "http://dummy.restapiexample.com/api/v1/"
    val aPIService: APIService
        get() = RetrofitClient.getClient(BASE_URL)!!.create(APIService::class.java)
}