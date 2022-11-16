package com.zybooks.whatsthevibe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import androidx.core.view.children

class QuizActivity : AppCompatActivity() {

    private lateinit var answerRadioGroup : RadioGroup
    private lateinit var nextButton : Button
    private lateinit var currentAnswer : String
    private var selectedAnswers = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        nextButton = findViewById(R.id.next_button)
        nextButton.setOnClickListener{view: View ->
            // push answer info in onNextClick!!
            onNextClick(view)
        }

        answerRadioGroup = findViewById(R.id.answer_radio_group)

        for (radioBtn in answerRadioGroup.children) {
            radioBtn.setOnClickListener(this::onAnswerSelected)
        }
    }

    private fun onNextClick(view: View){
        // make sure an answer is selected before we refresh activity!
        val isAnswerSelected = false

        if (isAnswerSelected && currentAnswer != null){
            // resets activity
            selectedAnswers.add(currentAnswer)
            if (selectedAnswers.count() == 10){
                // if they have answered 10 questions, then start the results activity
                val intent = Intent(this, ResultActivity::class.java)
                startActivity(intent)
            }
            // refreshes activity
            finish()
            startActivity(getIntent())
        }
    }

    private fun onAnswerSelected(view: View) {
        currentAnswer = when (view.id) {
            R.id.answer1 -> "Answer1"
            R.id.answer2 -> "Answer2"
            R.id.answer3 -> "Answer3"
            R.id.answer4 -> "Answer4"
            else -> "No Answer"
        }
    }

}