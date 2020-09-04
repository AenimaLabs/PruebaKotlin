package com.example.pruebakotlin.model.remote

import com.example.pruebakotlin.model.pojo.Pojo_SuperHeroes
import retrofit2.Call
import retrofit2.http.GET

interface SuperHeroApi {

    @GET("all.json")
    fun getSuperHeroesList() : Call<List<Pojo_SuperHeroes>>

//fun getSuperHeroesList() : Call<MutableList<Pojo_SuperHeroes>>  cuando se agrega el livedata
}