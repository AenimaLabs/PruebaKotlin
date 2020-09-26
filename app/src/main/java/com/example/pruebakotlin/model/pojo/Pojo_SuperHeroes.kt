package com.example.pruebakotlin.model.pojo

import androidx.annotation.NonNull
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity (tableName = "superhero_table")
data class Pojo_SuperHeroes(
    @PrimaryKey  @SerializedName ("id")val id:Int,
    @SerializedName ("name") val name: String,
 //  @Embedded val images: ImagesPojo
)




