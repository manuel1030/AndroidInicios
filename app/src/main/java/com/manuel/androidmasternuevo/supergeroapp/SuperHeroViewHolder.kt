package com.manuel.androidmasternuevo.supergeroapp

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.manuel.androidmasternuevo.databinding.ItemsSuperheroBinding
import com.squareup.picasso.Picasso


class SuperHeroViewHolder(view: View): RecyclerView.ViewHolder(view){

    private val binding = ItemsSuperheroBinding.bind(view)
    fun bind(superHeroItemResponse: SuperHeroItemResponse, onItemSelected:(String) -> Unit){
        binding.tvSuperHeroName.text = superHeroItemResponse.name
        Picasso.get().load(superHeroItemResponse.superHeroImage.url).into(binding.imgSuperHeroe)

        binding.root.setOnClickListener {
            onItemSelected(superHeroItemResponse.superHeroId)
        }
    }
}