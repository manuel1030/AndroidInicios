package com.manuel.androidmasternuevo.supergeroapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.manuel.androidmasternuevo.R

class SuperHeroAdapter (var superHeroList : List<SuperHeroItemResponse> = emptyList(), private val onItemSelected:(String) -> Unit) : RecyclerView.Adapter<SuperHeroViewHolder>() {

    fun updateList(superheroList: List<SuperHeroItemResponse>){
        this.superHeroList = superheroList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        return SuperHeroViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.items_superhero, parent, false))
    }

    override fun onBindViewHolder(viewholder: SuperHeroViewHolder, position: Int) {
        viewholder.bind(superHeroList[position], onItemSelected)
    }

    override fun getItemCount() = superHeroList.size

}
