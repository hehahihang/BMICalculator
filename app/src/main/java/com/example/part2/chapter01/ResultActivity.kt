package com.example.part2.chapter01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlin.math.pow
import kotlin.math.roundToLong

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height",0)
        val weight = intent.getIntExtra("weight",0)

        Log.d("ResultActiviy", "키 : $height 무게 : $weight")

        val bmi = weight / (height/100.0).pow(2.0)
        val bmiString = String.format("%.2f",bmi)

        val resultText = when{
            bmi >= 35.0 -> "고도비만"
            bmi >= 30.0 -> "중정도 비만"
            bmi >= 25.0 -> "경도비만"
            bmi >= 23.0 -> "과체중"
            bmi >= 18.5 -> "정상체중"
            else -> "저체중"
        }

        val resultTextview : TextView = findViewById(R.id.bmiText)
        val resultScoreview : TextView = findViewById(R.id.bmiScore)
        resultScoreview.text = bmiString;
        resultTextview.text = resultText

    }
}