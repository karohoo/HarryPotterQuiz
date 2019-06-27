package com.example.hpquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    private var question: TextView? = null
    private var score: TextView? = null
    private var questionCount: TextView? = null
    private var countDown: Chronometer? = null
    private var image: ImageView? = null
    private var iterator: Int = 0
    private var cAnswer: String = ""
    private var mScore: Int = 0
    private var qCount: Int = 1
    private var option: String = ""

    val questionList: MutableList<Question> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        question = findViewById(R.id.view_question_text)
        score = findViewById(R.id.view_score_text)
        questionCount = findViewById(R.id.question_count_text)
        countDown = findViewById(R.id.countdown_text)
        image = findViewById(R.id.quiz_image)

        newQuestion()

        val option1 = findViewById<Button>(R.id.option1)
        option1.setOnClickListener {
            option = option1.text.toString()
            checkAnswer()
        }

        val option2 = findViewById<Button>(R.id.option2)
        option2.setOnClickListener {
            option = option2.text.toString()
            checkAnswer()
        }

        val option3 = findViewById<Button>(R.id.option3)
        option3.setOnClickListener {
            option = option3.text.toString()
            checkAnswer()
        }

        val option4 = findViewById<Button>(R.id.option4)
        option4.setOnClickListener {
            option = option4.text.toString()
            checkAnswer()
        }

    }

    private fun newQuestion() {
        question?.text = addQuestions(iterator)
        option1?.text = addOption1(iterator)
        option2?.text = addOption2(iterator)
        option3?.text = addOption3(iterator)
        option4?.text = addOption4(iterator)
        image?.setImageResource(addImage(iterator))
        cAnswer = addCorrectAnswer(iterator)
        countdown_text.isCountDown = true
        countdown_text.base = SystemClock.elapsedRealtime() + 45000
        countdown_text.start()
        countdown_text.setOnChronometerTickListener {
            if (countdown_text.text.toString().equals("00:00")) {
                gameOver()
            }
        }
    }

    private fun addQuestions(i: Int): String {
        val question1 = Question("Which Potion is Known as \"Liquid Luck\"?",
            "Felix Felicis", "Polyjuice Potion", "Essence of Dittiny",
            "Bottled Fame", "Felix Felicis", R.drawable.liquidluck)

        val question2 = Question("Which of these was not a horcrux of Lord Voldemort?",
            "Nagini", "The Sword of Gryffindor", "The Diadem of Ravenclaw",
            "Tom Riddle's Diary", "The Sword of Gryffindor", R.drawable.voldemort)

        val question3 = Question("What was the name of the Weasleys' owl?",
            "Errol", "Hedwig", "Buckbeak", "Horus", "Errol", R.drawable.errol)

        val question4 = Question("What material is inside of Harry Potter's wand?",
            "Phoenix Tailfeathers", "Dragon Heartstrings", "Shards of Unicorn Horn",
            "Centaur Tears", "Phoenix Tailfeathers", R.drawable.wand)

        val question5 = Question("What was James Potter's nickname?", "Mooney", "Padfoot",
            "Prongs", "Wormtail", "Prongs", R.drawable.james)

        val question6 = Question("After all this time?", "Yes", "It never stops",
            "Always", "I still care", "Always", R.drawable.severus)

        val question7 = Question("What was Dumbledore's sisters name?", "Rita", "Minerva",
            "Abella", "Ariana", "Ariana", R.drawable.ariana)

        val question8 = Question( "Which of these wizards was not a Death Eater?", "Gragoravich",
            "Fenrir Greyback", "Peter Pettigrew", "Yaxley", "Gragoravich", R.drawable.deatheater)

        val question9 = Question("Finish this quote: \"I must not tell...\"", "Secrets", "Others",
            "Lies", "The truth", "Lies", R.drawable.umbridge)

        val question10 = Question("What is the name of Fred and George's joke shop?", "Weasley Joke Emporium",
            "Fred & George's Wonder Emporium", "Zonko's Joke Shop", "Weasley's Wizard Wheezes",
            "Weasley's Wizard Wheezes", R.drawable.fredgeorge)

        val question11 = Question("Which Harry Potter word is now in the Oxford English Dictionary?", "Hogwarts",
            "Voldemort", "Muggle", "Death Eater", "Muggle", R.drawable.hogwarts)

        val question12 = Question("In order of birth, who are the seven Weasley siblings?",
            "Percy, Bill, George, Charlie, Fred, Ron, Ginny", "George, Fred, Percy, Bill, Charlie, Ron, Ginny",
            "Fred, Bill, Charlie, Percy, George, Ron, Ginny","Bill, Charlie, Percy, Fred, George, Ron, Ginny",
            "Bill, Charlie, Percy, Fred, George, Ron, Ginny", R.drawable.weasley)

        val question13 = Question("What are the three Unforgivable Curses?", "Impedimenta, Incarcerous and Incendio",
            "Avada Kedavra, Crucio and Imperio", "Expelliarmus, Expecto Patronum and Diffindo",
            "Sectumsempra, Diffinfo and Crucio", "Avada Kedavra, Crucio and Imperio", R.drawable.avada)

        val question14 = Question("Who poses as Mad-Eye Moody, Harry's 4th year Defense Against the Dark Arts professor?", "" +
                "Peter Pettigrew", "Voldemort", "Sirius Black", "Barty Crouch, Jr",
            "Barty Crouch, Jr", R.drawable.madeye)

        val question15 = Question("When Dumbledore and Harry first visit Horace Slughorn, what is he disguised as?", "" +
                "An armchair", "A lampshade", "A house elf", "A giraffe",
            "An armchair", R.drawable.horace)

        questionList.add(question1)
        questionList.add(question2)
        questionList.add(question3)
        questionList.add(question4)
        questionList.add(question5)
        questionList.add(question6)
        questionList.add(question7)
        questionList.add(question8)
        questionList.add(question9)
        questionList.add(question10)
        questionList.add(question11)
        questionList.add(question12)
        questionList.add(question13)
        questionList.add(question14)
        questionList.add(question15)

        return questionList[i].component1()
    }

    private fun addOption1(i: Int): String {
        return questionList[i].component2()
    }

    private fun addOption2(i: Int): String {
        return questionList[i].component3()
    }

    private fun addOption3(i: Int): String {
        return questionList[i].component4()
    }

    private fun addOption4(i: Int): String {
        return questionList[i].component5()
    }

    private fun addCorrectAnswer(i: Int): String {
        return questionList[i].component6()
    }

    private fun addImage(i: Int): Int {
        return questionList[i].component7()
    }

    private fun checkAnswer() {
        if (option.equals(cAnswer)) {
            mScore++
            score?.text = "Score: " + mScore.toString()
            countGames()
        } else {
            countGames()
        }
    }

    private fun countGames() {
        if (iterator == 14) {
            gameOver()
        } else {
            qCount++
            questionCount?.text = "Question: " + qCount.toString() + "/15"
            iterator++
            newQuestion()
        }
    }

    private fun gameOver() {
        val intent = Intent(this@QuizActivity, ResultActivity::class.java).apply {
            putExtra("mScore", mScore.toString())
        }
        startActivity(intent)
        finish()
    }
}
