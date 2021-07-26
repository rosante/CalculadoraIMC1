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
            val message = textViewResult
            val weight = textWeight.text.toString()
            val height = textHeight.text.toString()
            message.setText(Calculate(weight=weight, height=height))
        }


    }

    fun Calculate(height:String, weight:String):String{
        val imc = weight.toDouble()/(height.toDouble()*height.toDouble())
        val pesoIdealMin = (height.toDouble()*height.toDouble())*(18.5)
        val pesoIdealMax = (height.toDouble()*height.toDouble())*(25)
        var message:String
        when {
            imc < (18.5).toDouble() -> message="Magreza"
            imc in (18.5).toDouble()..(25).toDouble() -> message="Peso Normal"
            imc in (25).toDouble()..(30).toDouble() -> message="Acima do Peso"
            imc in (30).toDouble()..(40).toDouble() -> message="Obeso"
            imc > (40).toDouble() -> message="Muito Obeso"
            else -> message="Erro"
        }
        message +=  "\nSeu peso ideal seria entre ${pesoIdealMin.toInt().toString()} Kgs e ${pesoIdealMax.toInt().toString()} Kgs"
        return message
    }
}