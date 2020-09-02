package com.example.pruebakotlin.model.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity (tableName = "superhero_table")
data class Pojo_SuperHeroes(
    @PrimaryKey val id:Int, val name: String
)