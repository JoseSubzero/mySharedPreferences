package com.example.mysharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.mysharedpreferences.SharedPreferences.Companion.prefs
import com.example.mysharedpreferences.databinding.ActivityAccessBinding

class AccessActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAccessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    fun initUI(){
        binding.btnClose.setOnClickListener {
            prefs.wipeData()
            onBackPressed()
        }

        val userName = prefs.getName()
        binding.tvHello.text = "¡Hola $userName!"
        if (prefs.getColorCheck()) {
            binding.ContainerCardView.setBackgroundColor(
                ContextCompat.getColor(this, R.color.purple_200)
            )
        }
    }
}