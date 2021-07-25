package com.ruzzante.calculadoradepeso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnCalculate.setOnClickListener{
            val gender = if (radioFemale.isChecked) "female"; else { "male" }
            val message = textViewResult
            val weight = textWeight.text.toString()
            val height = textHeight.text.toString()
            message.setText(Calculate(gender, weight=weight, height=height))
            //message.setText("$gender $weight $height")
        }


    }

    fun Calculate(gender:String, height:String, weight:String):String{
        if (gender == "male"){
            val imc = weight.toDouble()/(height.toDouble()*height.toDouble())
            val message:String
            when {
                imc < (18.5).toDouble() -> message="Magreza"
                imc in (18.5).toDouble()..(24.9).toDouble() -> message="Peso Normal"
                imc in (25).toDouble()..(30).toDouble() -> message="Acima do Peso"
                imc > 30.toDouble() -> message="Obeso"
                else -> message="Erro"
            }
            return message
        }
        return "Erro"
    }
}