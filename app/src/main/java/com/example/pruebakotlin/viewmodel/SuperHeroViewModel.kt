package com.example.pruebakotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.example.pruebakotlin.model.SuperHeroRepository
import com.example.pruebakotlin.model.pojo.Pojo_SuperHeroes
import kotlinx.coroutines.launch

class SuperHeroViewModel (application: Application) : AndroidViewModel(application) {

    private val repository= SuperHeroRepository(application)
    private val shList = repository.passLiveDataToViewModel()


    fun insertSuperHeroList(list: MutableList<Pojo_SuperHeroes>) = viewModelScope.launch {  }

    fun insertSuperHero(post: Pojo_SuperHeroes) = viewModelScope.launch {  }

    fun updateSuperHero(post: Pojo_SuperHeroes) = viewModelScope.launch {  }
//
//
//    fun insertSuperHero(post: Pojo_SuperHeroes)
//
//
//    fun updateSuperHero(post: Pojo_SuperHeroes)

    fun getSuperHeroList(): LiveData<MutableList<Pojo_SuperHeroes>>{
        return shList
    }

    fun fetchFromServer(){
        repository.fetchDataFromServer()
    }
}