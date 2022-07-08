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
            val theColor = getMyColor(prefs.getSpinner())
            binding.ContainerCardView.setBackgroundColor(
                ContextCompat.getColor(this, theColor)
            )
        }
    }

    fun getMyColor(color:String):Int{
        val resourceColor = when(color){
            "yellow" -> R.color.yellow
            "red" -> R.color.red
            "orange" -> R.color.orange
            "blue" -> R.color.blue
            "green" -> R.color.green
            "gray" -> R.color.gray
            "Purple" -> R.color.purple
            else -> R.color.white
        }
        return resourceColor
    }
}