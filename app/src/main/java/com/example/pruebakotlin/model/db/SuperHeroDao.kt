package com.example.pruebakotlin.model.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.pruebakotlin.model.pojo.Pojo_SuperHeroes
import retrofit2.http.POST

@Dao
interface SuperHeroDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSuperHeroList(list: MutableList<Pojo_SuperHeroes>)

    @Insert
    suspend fun insertSuperHero(post: Pojo_SuperHeroes)

    @Update
    suspend fun updateSuperHero(post: Pojo_SuperHeroes)

    @Query ("SELECT * FROM superhero_table ORDER BY id  DESC")
    fun getAllSuperHeroes(): LiveData<MutableList<Pojo_SuperHeroes>>
}