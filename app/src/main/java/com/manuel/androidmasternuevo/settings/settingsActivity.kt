package com.manuel.androidmasternuevo.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.manuel.androidmasternuevo.R
import com.manuel.androidmasternuevo.databinding.ActivitySettingsBinding
import com.manuel.androidmasternuevo.databinding.DialogTaskBinding

class settingsActivity : AppCompatActivity() {
    private  lateinit var binding: ActivitySettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}