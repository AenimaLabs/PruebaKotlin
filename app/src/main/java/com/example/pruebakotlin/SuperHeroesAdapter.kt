package com.example.pruebakotlin

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebakotlin.remote_data_source.retrofit.pojo.Pojo_SuperHeroes
import kotlinx.android.synthetic.main.superhero_list.view.*

class SuperHeroesAdapter(private val myDataHeroe: List<Pojo_SuperHeroes>): RecyclerView.Adapter<SuperHeroesAdapter.SuperHeroeHolder>() {

    override fun onCreateViewHolder(holder: SuperHeroeHolder, position: Int){
        val pojoSuperheroes = myDataHeroe[position]
        holder.
    }

    class SuperHeroeHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        var name : TextView = itemView.fullname
        var firstApp : TextView = itemView.firtsAppearance

    }

}