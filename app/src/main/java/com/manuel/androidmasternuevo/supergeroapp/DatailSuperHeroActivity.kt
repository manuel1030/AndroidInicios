package com.manuel.androidmasternuevo.supergeroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import com.manuel.androidmasternuevo.R
import com.manuel.androidmasternuevo.databinding.ActivityDatailSuperHeroBinding
import com.manuel.androidmasternuevo.databinding.ActivitySuperHerolistBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

class DatailSuperHeroActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_ID = "extra_id"
    }

    private lateinit var binding: ActivityDatailSuperHeroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatailSuperHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id : String= intent.getStringExtra(EXTRA_ID).orEmpty()

        getSuperHeroInformation(id)
    }
    private fun  getSuperHeroInformation(id : String){
        CoroutineScope(Dispatchers.IO).launch {
           val superHeroDetail = getRetrofit().create(ApiService::class.java).getSuperHeroID(id)
            if(superHeroDetail.body() != null){
                runOnUiThread{
                    createUI(superHeroDetail.body()!!)
                }

            }
        }
    }

    private fun createUI(superHero: SuperHeroDatailresponse) {
        Picasso.get().load(superHero.image.url).into(binding.ivSuperHero)
        binding.tvSuperHero.text = superHero.name
        binding.tvSuperHeroRealName.text = superHero.biography.fullbname
        binding.tvSuperHeroPublisher.text = superHero.biography.publisher
        binding.tvsuperHeroConection.text = superHero.connections.groupaaffiliation
        prepareStats(superHero.powerstats)
    }

    private fun prepareStats(powerstats: PowerstatsResponse) {
        updateHeingt(binding.viewCombat, powerstats.combat)
        updateHeingt(binding.viewDurability, powerstats.durability)
        updateHeingt(binding.viewPower, powerstats.power)
        updateHeingt(binding.viewSpeed, powerstats.speed)
        updateHeingt(binding.viewStrength, powerstats.strength)
        updateHeingt(binding.viewIelligence, powerstats.intelligence)
    }
    private fun pxToDp(px:Float):Int{
       return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics).roundToInt()
    }
    private fun  updateHeingt(view: View, stat : String){
        val params = view.layoutParams
        params.height = pxToDp( stat.toFloat())
        view.layoutParams = params
    }
    private fun getRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl("https://superheroapi.com/").addConverterFactory(GsonConverterFactory.create()).build()
    }
}