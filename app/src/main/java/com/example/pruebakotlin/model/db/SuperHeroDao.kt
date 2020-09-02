package com.example.pruebakotlin.model.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.pruebakotlin.model.pojo.Pojo_SuperHeroes

@Dao
interface SuperHeroDao {

    @Query ("SELECT * FROM superhero_table ORDER BY id  DESC")
    fun getAllSuperHeroes(): LiveData<List<Pojo_SuperHeroes>>
}