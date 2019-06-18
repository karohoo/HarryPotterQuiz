package com.example.hpquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.R
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView


class QuizActivity : AppCompatActivity() {

    private var textViewQuestion: TextView? = null
    private var textViewScore: TextView? = null
    private var textViewQuestionCount: TextView? = null
    private var textViewCountDown: TextView? = null
    private var rbGroup: RadioGroup? = null
    private var rb1: RadioButton? = null
    private var rb2: RadioButton? = null
    private var rb3: RadioButton? = null
    private var buttonConfirmNext: Button? = null
    private var questionList: List<Question>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.hpquiz.R.layout.activity_quiz)

        textViewQuestion = findViewById(com.example.hpquiz.R.id.view_question_text)
        textViewScore = findViewById(com.example.hpquiz.R.id.view_score_text)
        textViewQuestionCount = findViewById(com.example.hpquiz.R.id.question_count_text)
        textViewCountDown = findViewById(com.example.hpquiz.R.id.countdown_text)
        rbGroup = findViewById(com.example.hpquiz.R.id.radio_group)
        rb1 = findViewById(com.example.hpquiz.R.id.radio_button1)
        rb2 = findViewById(com.example.hpquiz.R.id.radio_button2)
        rb3 = findViewById(com.example.hpquiz.R.id.radio_button3)
        buttonConfirmNext = findViewById(com.example.hpquiz.R.id.confirm_button)

        val dbHelper = QuizDbHelper(this)
        questionList = dbHelper.getAllQuestions()
    }
}
