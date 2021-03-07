package com.example.retrofit.data

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl("https://api.github.com/")
    .build()

interface GithubApi{
    @GET("repos/laravel/laravel/contributors")
    fun showList(): Call<List<GithubData>>
}

object GithubService {
    val retrofitService = retrofit.create(GithubApi::class.java)
}
