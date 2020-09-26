package com.example.pruebakotlin.model

import android.content.Context
import android.util.Log
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
    private val superheroList = db.getsuperheroDao().getAllSuperHeroes()



    fun passLiveDataToViewModel() : LiveData<MutableList<Pojo_SuperHeroes>>{
        return superheroList
    }

    //llamando a retrofit
    fun fetchDataFromServer(){
        val service = RetrofitClient.retrofitInstance()
        val call = service.getSuperHeroesList()

       call.enqueue(object : Callback<MutableList<Pojo_SuperHeroes>>{
           override fun onResponse(
               call: Call<MutableList<Pojo_SuperHeroes>>,
               response: Response<MutableList<Pojo_SuperHeroes>>
           ) {
//               val superheroesList = mutableListOf<Pojo_SuperHeroes>()
//               response.body()?.forEach {
//                   superheroesList.add(Pojo_SuperHeroes(id = it.id, name = it.name, images = it.images))
//               }
               when(response.code()) {
                   in 200..299 ->
                      Log.wtf(tag, response.body().toString())
               CoroutineScope(Dispatchers.IO).launch{
                   response.body()?.let { db.getsuperheroDao().insertSuperHeroList(it) }

               }
                   in 300..399 -> Log.d("ERROR 300", response.errorBody().toString())
               }
           }


           override fun onFailure(call: Call<MutableList<Pojo_SuperHeroes>>, t: Throwable) {
               Log.wtf(tag, t.message.toString())
           }


       })}

}