package com.example.pruebakotlin.remote_data_source.retrofit.remote

import com.example.pruebakotlin.remote_data_source.retrofit.pojo.Pojo_SuperHeroes
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("1.json")
    fun getSuperHeroes() : Call<List<Pojo_SuperHeroes>>

}