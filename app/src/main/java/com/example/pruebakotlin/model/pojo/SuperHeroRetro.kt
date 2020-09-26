package com.example.pruebakotlin.model.pojo

import androidx.annotation.NonNull
import androidx.room.Embedded
import androidx.room.PrimaryKey

class SuperHeroRetro (val id:Int, val name: String,
                      val images: ImagesPojo)
