package com.example.hpquiz

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class QuizActivity : AppCompatActivity() {

    var QuestionList: MutableList<Questions> = ArrayList()
    private var question: TextView? = null
    private var score: TextView? = null
    private var questionCount: TextView? = null
    private var countDown: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        question = findViewById(R.id.view_question_text)
        score = findViewById(R.id.view_score_text)
        questionCount = findViewById(R.id.question_count_text)
        countDown = findViewById(R.id.countdown_text)


        val option1 = findViewById<Button>(R.id.option1)
        option1.setOnClickListener {

        }

        val option2 = findViewById<Button>(R.id.option2)
        option2.setOnClickListener {

        }

        val option3 = findViewById<Button>(R.id.option3)
        option3.setOnClickListener {

        }

        val option4 = findViewById<Button>(R.id.option4)
        option4.setOnClickListener {

        }

        newQuestion()

    }

    private fun newQuestion(){
        
    }

}
