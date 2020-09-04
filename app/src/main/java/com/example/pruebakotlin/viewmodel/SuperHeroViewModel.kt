package com.example.pruebakotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.pruebakotlin.model.SuperHeroRepository
import com.example.pruebakotlin.model.pojo.Pojo_SuperHeroes

class SuperHeroViewModel (application: Application) : AndroidViewModel(application) {

    private val repository= SuperHeroRepository(application)
    private val shList = repository.passLiveDataToViewModel()



    fun getSuperHeroList(): LiveData<List<Pojo_SuperHeroes>>{
        return shList
    }

    fun fetchFromServer(){
        repository.fetchDataFromServer()
    }
}