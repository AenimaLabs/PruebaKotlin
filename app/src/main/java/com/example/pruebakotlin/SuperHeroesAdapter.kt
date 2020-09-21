package com.example.pruebakotlin

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebakotlin.model.pojo.Pojo_SuperHeroes
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.superhero_list.view.*

class SuperHeroesAdapter(var myDataHeroe: MutableList<Pojo_SuperHeroes>): RecyclerView.Adapter<SuperHeroesAdapter.SuperHeroeHolder>() {

    class SuperHeroeHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        var id : TextView = itemView.idhero
        var name : TextView = itemView.name
        var image: ImageView = itemView.imageView

    }

    fun updateData(listPost: MutableList<Pojo_SuperHeroes>) {
        Log.d("UPDATE", "update ${listPost.size}")
        myDataHeroe = listPost
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroeHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.superhero_list, parent, false)
//        val holder = SuperHeroeHolder(view)
//        holder.id = view.idhero
//        holder.name = view.name
//        holder.image = view.imageView

        return SuperHeroeHolder(view)
    }

    override fun onBindViewHolder(holder: SuperHeroeHolder, position: Int) {
        val superheroe = myDataHeroe[position]
        holder.id.text = superheroe.id.toString()
        holder.name.text = superheroe.name

//       Picasso.get().load(superheroe.images.md).into(holder.image)
//       holder.image.tag = superheroe.images

    }

    override fun getItemCount(): Int {
        return myDataHeroe.size
    }



}