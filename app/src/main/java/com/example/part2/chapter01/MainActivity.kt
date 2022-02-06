package com.example.part2.chapter01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.part2.chapter01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //뷰 바인딩 사용방법
    //1. 레이아웃이되는 XML 파일 생성
    //2. 바인딩 초기화
    //3. root뷰(레이아웃) 표시
    //4. ID로 뷰에 접근
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEditText: EditText = findViewById(R.id.editTextHeight)
        val weightEditText = findViewById<EditText>(R.id.editTextWeight)

        val resultBuuton : Button = findViewById(R.id.buttonResult)

        //setOnclickListner 안에서 동작하는 것을 람다식으로 표현
        resultBuuton.setOnClickListener{
            Log.d("MainActivity","Result 버튼이 클릭됌")

            if(heightEditText.text.isEmpty() || weightEditText.text.isEmpty()){
                Toast.makeText(this,"빈 값이 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var height : Int = heightEditText.text.toString().toInt();
            var weight : Int = weightEditText.text.toString().toInt();

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("height",height);
            intent.putExtra("weight",weight)
            startActivity(intent)
        }
    }
}