package com.example.pruebakotlin.model.db

import android.app.Application
import androidx.room.Room

class SuperHeroDBInstance: Application() {

    companion object {
        lateinit var database: SuperHeroDB
    }

    override fun onCreate() {
        super.onCreate()
        database= Room.databaseBuilder(this, SuperHeroDB::class.java, "superhero_database").build()
    }
}