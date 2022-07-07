package com.example.mysharedpreferences

import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

//fun getSpinner(myContext: Context, mySpinner: Spinner, opSelect:Array<String>, data: Int){
//    val adaptador: ArrayAdapter<*> = ArrayAdapter.createFromResource(myContext, data,
//        android.R.layout.simple_spinner_item)
//    mySpinner.adapter = adaptador
//    mySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//        override fun onItemSelected(
//            parent: AdapterView<*>?,
//            view: View?,
//            position: Int,
//            id: Long
//        ) {
//            opSelect[0] = parent?.getItemAtPosition(position).toString()
//        }
//
//        override fun onNothingSelected(parent: AdapterView<*>?) {
//            opSelect[0] = "No ha habido selección"
//        }
//    }
//}
//
//fun msj(myContext: Context, str:String, lengthSort:Boolean = true){
//    Toast.makeText(myContext, str,
//        if (lengthSort) Toast.LENGTH_SHORT
//        else Toast.LENGTH_LONG
//    ).show()
//}