package com.manuel.androidmasternuevo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.manuel.androidmasternuevo.firstapp.FirsappActivity
import com.manuel.androidmasternuevo.imccalculador.imcCalculadorActivity
import com.manuel.androidmasternuevo.settings.settingsActivity
import com.manuel.androidmasternuevo.supergeroapp.SuperHerolistActivity
import com.manuel.androidmasternuevo.todoapp.TodoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnSaludApp = findViewById<Button>(R.id.btnSaludApp)
        val btnImcApp = findViewById<Button>(R.id.btnIMCApp)
        val btnTODO = findViewById<Button>(R.id.btnTODO)
        val btnSuperHero = findViewById<Button>(R.id.btnSuperHero)
        val btnSettings = findViewById<Button>(R.id.btnSettings)
        btnSaludApp.setOnClickListener{
            navigateToSaludApp()
        }
        btnImcApp.setOnClickListener{navigateToImcApp()}
        btnTODO.setOnClickListener { navigateTodoApp() }
        btnSuperHero.setOnClickListener { navigateSuperHero() }
        btnSettings.setOnClickListener {  navigateSettings() }
    }

    private fun navigateSuperHero() {
        val intent = Intent(this, SuperHerolistActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludApp(){
        val intent = Intent(this, FirsappActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToImcApp(){
        val intent = Intent(this, imcCalculadorActivity::class.java)
        startActivity(intent)
    }
    private fun navigateTodoApp(){
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }
    private fun  navigateSettings(){
        val intent = Intent(this, settingsActivity::class.java)
    }
}