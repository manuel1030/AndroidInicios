package com.manuel.androidmasternuevo.supergeroapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import com.manuel.androidmasternuevo.R
import  androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.manuel.androidmasternuevo.databinding.ActivitySuperHerolistBinding
import com.manuel.androidmasternuevo.supergeroapp.DatailSuperHeroActivity.Companion.EXTRA_ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SuperHerolistActivity : AppCompatActivity() {
    private lateinit var binging: ActivitySuperHerolistBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: SuperHeroAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binging = ActivitySuperHerolistBinding.inflate(layoutInflater)
        setContentView(binging.root)
        retrofit = getRetrofit()
        initUI()
    }

    private fun initUI() {
        binging.searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?) = false;

        })

        adapter = SuperHeroAdapter{
            superHeroId -> navigatetoDetailt(superHeroId)
        }
        binging.rcSuperHero.setHasFixedSize(true)
        binging.rcSuperHero.layoutManager = LinearLayoutManager(this)
        binging.rcSuperHero.adapter = adapter

    }

    private fun searchByName(query: String) {
        binging.progressbar.isVisible = true;
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: retrofit2.Response<SuperHeroDataResponse> = retrofit.create(ApiService::class.java).getSuperHeroes(query)
            if(myResponse.isSuccessful){
                var response : SuperHeroDataResponse ?= myResponse.body()
                if(response != null){
                    Log.i("Manuel", response.toString())
                    runOnUiThread {
                        adapter.updateList(response.results)
                        binging.progressbar.isVisible = false
                    }
                }
            }
            else{
                Log.i("Manuel","no funciona :/")
            }
        }
    }

    private fun getRetrofit(): Retrofit {
      return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun navigatetoDetailt(id:String){
        var intent = Intent(this, DatailSuperHeroActivity::class.java)
        intent.putExtra(EXTRA_ID, id)
        startActivity(intent)
    }
}

