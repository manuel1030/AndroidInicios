package com.manuel.androidmasternuevo.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import com.manuel.androidmasternuevo.R

class FirsappActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firsapp)
        //Al arrancar la pantalla
        val btnclick = findViewById<AppCompatButton>(R.id.btnclick)
        val etname = findViewById<EditText>(R.id.etname)

        btnclick.setOnClickListener{
            val name = etname.text.toString()
            if(!name.isEmpty()){
                val intent = Intent(this, ResultActivity::class.java);
                intent.putExtra("Extraname",name)
                startActivity(intent)
            }

        }
    }
}