package com.example.pruebakotlin.model.remote

import com.example.pruebakotlin.model.pojo.Pojo_SuperHeroes
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("all.json")
    fun getSuperHeroes() : Call<List<Pojo_SuperHeroes>>

}