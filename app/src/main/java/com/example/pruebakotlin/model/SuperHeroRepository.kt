package com.example.pruebakotlin.model

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import com.example.pruebakotlin.model.db.SuperHeroDB
import com.example.pruebakotlin.model.pojo.Pojo_SuperHeroes
import com.example.pruebakotlin.model.remote.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SuperHeroRepository (context : Context) {

    private val tag = "SuperHeroRepository"

    //desde la database
    private val db: SuperHeroDB = SuperHeroDB.getDatabase(context)
    private val superheroList = db.superheroeDao().getAllSuperHeroes()

    fun passLiveDataToViewModel() : LiveData<List<Pojo_SuperHeroes>>{
        return superheroList
    }

    //llamando a retrofit
    fun fetchDataFromServer(){
        val service = RetrofitClient.retrofitInstance()
        val call = service.getSuperHeroes()

       call.enqueue(object : Callback<List<Pojo_SuperHeroes>>{
           override fun onResponse(
               call: Call<List<Pojo_SuperHeroes>>,
               response: Response<List<Pojo_SuperHeroes>>
           ) {
               Log.wtf(tag, response.body().toString())
               CoroutineScope(Dispatchers.IO).launch { response.body()?.let { db.superheroeDao().getAllSuperHeroes() } }
           }

           override fun onFailure(call: Call<List<Pojo_SuperHeroes>>, t: Throwable) {
               Log.wtf(tag, t.message.toString())
           }


       })}

}