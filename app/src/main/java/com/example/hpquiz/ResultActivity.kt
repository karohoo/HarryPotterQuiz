package com.example.hpquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val mScore = intent.getStringExtra("mScore")
        result.text = "Your score is " + mScore + "/15"
        val play = findViewById<Button>(R.id.play)
        play.setOnClickListener {
            val intent = Intent(this@ResultActivity, QuizActivity::class.java)
            startActivity(intent)
        }
    }
}
