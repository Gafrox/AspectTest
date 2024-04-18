package com.example.aspecttest.network

import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

private const val BASE_URL =
    "https://eam-demo.aspectnet.ru/platform/api/dm/rest/noAuth/actions/"

val interceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}
val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .client(client)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val apiService = retrofit.create(RetrofitApi::class.java)

interface RetrofitApi {

    @POST("caede3a6-d7e5-4a50-b283-4b20b07eb3fb/run")
    suspend fun getEquipmentList(@Body body: RequestBody = "{}".toRequestBody()): EquipmentResponse

    @POST("22bedbbd-9b7b-43d3-8f2f-e53f90b1faf9/run")
    suspend fun getEquipmentById(@Body body: EquipmentIdRequest): EquipmentDetailResponse
}