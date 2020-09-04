package com.example.pruebakotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebakotlin.model.pojo.Pojo_SuperHeroes
import com.example.pruebakotlin.viewmodel.SuperHeroViewModel
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_super_hero_list.view.*


class SuperHeroFragment () : Fragment(){

    lateinit var viewModel: SuperHeroViewModel
    lateinit var viewAdapter: SuperHeroesAdapter
    lateinit var superHeroList: ArrayList<Pojo_SuperHeroes>
    lateinit var listView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SuperHeroViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_super_hero_list, container, false)

//        viewAdapter = SuperHeroesAdapter(superHeroList)
//        recyclerViewSH.adapter = viewAdapter

        listView= view.recyclerViewSH
        listView.layoutManager = LinearLayoutManager(context)
     //   viewModel.getSuperHeroList().observe(context as MainActivity, { listView.adapter = SuperHeroesAdapter(it, context as MainActivity) })


             return view
    }
}