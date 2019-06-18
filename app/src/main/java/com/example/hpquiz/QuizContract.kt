package com.example.hpquiz

import android.provider.BaseColumns


object QuizContract {

    class QuestionsTable : BaseColumns {
        companion object {
            val TABLE_NAME = "quiz_questions"
            val _ID = "_id"
            val COLUMN_QUESTION = "question"
            val COLUMN_OPTION1 = "option1"
            val COLUMN_OPTION2 = "option2"
            val COLUMN_OPTION3 = "option3"
            val COLUMN_ANSWER_NR = "answer_nr"
        }
    }
}