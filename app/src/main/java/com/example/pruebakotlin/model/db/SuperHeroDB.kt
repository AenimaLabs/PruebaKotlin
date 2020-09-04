package com.example.pruebakotlin.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pruebakotlin.model.pojo.Pojo_SuperHeroes

@Database(entities = [Pojo_SuperHeroes::class], version = 1, exportSchema = false)
abstract class SuperHeroDB : RoomDatabase() {

    abstract fun getsuperheroDao() : SuperHeroDao

    companion object{
        @Volatile
        private var INSTANCE: SuperHeroDB? = null

        fun getDatabase (context: Context) : SuperHeroDB {
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,SuperHeroDB::class.java,
                    "superhero_database").build()
                INSTANCE= instance
                return instance

            }
        }
    }

}