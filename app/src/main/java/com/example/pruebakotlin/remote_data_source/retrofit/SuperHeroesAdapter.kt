package com.example.pruebakotlin.remote_data_source.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebakotlin.R
import com.example.pruebakotlin.remote_data_source.retrofit.pojo.Pojo_SuperHeroes
import kotlinx.android.synthetic.main.superhero_list.view.*

class SuperHeroesAdapter(private val myDataHeroe: List<Pojo_SuperHeroes>):
    RecyclerView.Adapter<SuperHeroesAdapter.SuperHeroeHolder>() {

    class SuperHeroeHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        var id : TextView = itemView.idhero
        var name : TextView = itemView.name
        var fullname : TextView = itemView.fullname
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroeHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.superhero_list, parent, false)
        return SuperHeroeHolder(view)
    }

    override fun onBindViewHolder(holder: SuperHeroeHolder, position: Int) {
        val superheroe = myDataHeroe[position]
        holder.id.text = superheroe.id.toString()
        holder.name.text = superheroe.name
        holder.fullname.text = superheroe.fullName


//        val aliases: List<String>,
//        val alignment: String,
//        val alterEgos: String,
//        val firstAppearance: String,
//        val fullName: String,
//        val placeOfBirth: String,
//        val publisher: String
    }

    override fun getItemCount(): Int {
        return myDataHeroe.size
    }


}