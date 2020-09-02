package com.example.pruebakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebakotlin.remote_data_source.retrofit.SuperHeroesAdapter
import com.example.pruebakotlin.model.pojo.Pojo_SuperHeroes
import com.example.pruebakotlin.model.remote.RetrofitClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var superHList = ArrayList<Pojo_SuperHeroes>()
    private lateinit var viewAdapter: RecyclerView.Adapter<*>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewAdapter = SuperHeroesAdapter(superHList)
        pojoRecyclerView.adapter= viewAdapter

        loadApiData()
    }

    private fun loadApiData(){
        val service = RetrofitClient.retrofitInstance()
        val call = service.getSuperHeroes()

        call.enqueue(object : Callback<List<Pojo_SuperHeroes>> {
            override fun onResponse(
                call: Call<List<Pojo_SuperHeroes>>,
                response: Response<List<Pojo_SuperHeroes>>
            ) {
                response.body()?.map {
                    Log.wtf("MAIN", "${it.id} - ${it.name}")
                    superHList.add(it)
                }
                viewAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<Pojo_SuperHeroes>>, t: Throwable) {
                Log.wtf("MAIN", "Errir" + t)
                Toast.makeText(applicationContext, "Error: cagó la weá", Toast.LENGTH_SHORT).show()
            }


        })
    }
}