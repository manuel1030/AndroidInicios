package com.manuel.androidmasternuevo.imccalculador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.manuel.androidmasternuevo.R
import com.manuel.androidmasternuevo.imccalculador.imcCalculadorActivity.Companion.IMC_KEY
import java.text.DecimalFormat

class ResultIMCActivity : AppCompatActivity() {
    private lateinit var tvresult : TextView
    private lateinit var tvIMC : TextView
    private lateinit var tvDescription : TextView
    private lateinit var btnrecalculate : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)
        val result : Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        initComponents()
        initUI(result)
        initListeners()
    }
    private fun initComponents(){
        tvresult = findViewById(R.id.tvresult)
        tvIMC = findViewById(R.id.tvIMC)
        tvDescription = findViewById(R.id.tvDescription)
        btnrecalculate = findViewById(R.id.btnrecalculate)

    }
    private fun initUI(result:Double){
        val df = DecimalFormat("#.##")
        tvIMC.text = df.format ( result)
        when(result){
            in 0.00..18.50->{//Peso bajo
                getIMC(getString(R.string.title_bajo_peso), getString(R.string.descripcion_bajo_peso))
                tvresult.setTextColor(ContextCompat.getColor(this, R.color.peso_bajo))
            }
            in 18.51..24.99->{//Sobre normal
              getIMC(getString(R.string.title_peso_normal), getString(R.string.descripcion_peso_normal))
                tvresult.setTextColor(ContextCompat.getColor(this, R.color.peso_normal))
            }
            in 25.00..29.99->{//sobrepeso
                getIMC(getString(R.string.title_sobre_peso), getString(R.string.descripcion_sobre_peso))
                tvresult.setTextColor(ContextCompat.getColor(this, R.color.peso_pasado))
            }
            in 30.00..99.99->{//Obesidad
                getIMC(getString(R.string.title_obesidad), getString(R.string.descripcion_obesidad))
                tvresult.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
            }
            else -> { // Error
                tvIMC.text = getString(R.string.error)
                tvresult.text = getString(R.string.error)
                tvDescription.text = getString(R.string.error)
                tvresult.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
            }
        }
    }
    private fun getIMC(titulo:String, descripcion:String){
        tvresult.text = titulo;
        tvDescription.text = descripcion;
    }
    private fun initListeners(){
        btnrecalculate.setOnClickListener {
            onBackPressed()
        }
    }
}