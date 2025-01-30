package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val btnStar : Button = findViewById(R.id.bts_start)
        val etName : EditText = findViewById(R.id.etName)
        btnStar.setOnClickListener {
            if(etName.text.isEmpty()){
                Toast.makeText(this, "Please Enter your Name", Toast.LENGTH_LONG).show()
            }
            else{
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.UESR_NAME, etName.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}

