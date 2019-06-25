package com.example.hpquiz

import android.graphics.drawable.Drawable
import android.media.Image

data class Question (var question: String, var option1: String, var option2: String, var option3: String,
                     var option4: String, var correctAnswer: String, var image: Int)