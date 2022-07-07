package com.example.mysharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mysharedpreferences.SharedPreferences.Companion.prefs
import com.example.mysharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
        checkUserValues()
    }



    private fun initUI() {
        binding.btnEnter.setOnClickListener {
            accessSharedPreferences()
        }
    }
    private fun checkUserValues() {
        if(prefs.getName().isNotEmpty()){
            goAccess()
        }
    }

    fun accessSharedPreferences(){
        if (binding.etName.text.toString().isNotEmpty()){
            prefs.saveName(binding.etName.text.toString())
            prefs.saveColor(binding.cbBackgroundColor.isChecked)
            goAccess()
        } else{
            Toast.makeText(this, "Debe rellenar el nombre", Toast.LENGTH_SHORT).show()
        }
    }

    private fun goAccess(){
        startActivity(Intent(this, AccessActivity::class.java))
    }


}