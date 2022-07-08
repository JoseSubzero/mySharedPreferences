package com.example.mysharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.core.view.get
import com.example.mysharedpreferences.SharedPreferences.Companion.prefs
import com.example.mysharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var opSelect = "Amarillo"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getSpinner(binding.spColor, R.array.colors)

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
            prefs.saveSpinner(opSelect)
            goAccess()
        } else{
            Toast.makeText(this, "Debe rellenar el nombre", Toast.LENGTH_SHORT).show()
        }
    }

    private fun goAccess(){
        startActivity(Intent(this, AccessActivity::class.java))
    }
    fun getSpinner( mySpinner: Spinner, data: Int){
        val adaptador: ArrayAdapter<*> = ArrayAdapter.createFromResource(this, data,
            android.R.layout.simple_spinner_item)
        mySpinner.adapter = adaptador
        mySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                opSelect = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                opSelect = "Verde"
            }
        }
    }

}