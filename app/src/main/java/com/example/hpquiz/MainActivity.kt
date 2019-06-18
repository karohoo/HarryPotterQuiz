package com.example.hpquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val buttonStartQuiz = findViewById<Button>(R.id.button_start_quiz)
        buttonStartQuiz.setOnClickListener(View.OnClickListener { startQuiz() })
    }

    private fun startQuiz() {
        val intent = Intent(this@MainActivity, QuizActivity::class.java)
        startActivity(intent)
    }
}


