package com.manuel.androidmasternuevo.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.manuel.androidmasternuevo.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val tvResult = findViewById<TextView>(R.id.tvResul)
        val name:String = intent.extras?.getString("Extraname").orEmpty()
        tvResult.text = "Hola $name"
    }
}