package com.example.pruebakotlin.remote_data_source.retrofit.pojo

import com.google.gson.annotations.SerializedName

data class Pojo_SuperHeroes(
    @SerializedName ("id" ) val id:Int, val name: String, val fullName: String
)