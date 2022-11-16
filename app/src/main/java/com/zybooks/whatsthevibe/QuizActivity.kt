package com.zybooks.whatsthevibe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.view.children

class QuizActivity : AppCompatActivity() {

    private lateinit var answerRadioGroup : RadioGroup
    private lateinit var nextButton : Button
    private lateinit var currentAnswer : String
    private lateinit var QuestionText : TextView
    private lateinit var Answer1 : RadioButton
    private lateinit var Answer2 : RadioButton
    private lateinit var Answer3 : RadioButton
    private lateinit var Answer4 : RadioButton
    private var selectedAnswers = arrayListOf<String>()
    private var nextButtonClicks : Int = 0
    private val QuestionsAnswers = QuestionsAnswer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)


        //QuestionText.setText(QuestionsAnswer.Questions[0])
        QuestionText = findViewById(R.id.question_text)
        Answer1 = findViewById(R.id.answer1)
        Answer2 = findViewById(R.id.answer2)
        Answer3 = findViewById(R.id.answer3)
        Answer4 = findViewById(R.id.answer4)
        if (nextButtonClicks == 0){
            QuestionText.setText(QuestionsAnswers.Questions[0])
            Answer1.setText(QuestionsAnswers.AllAnswers[0][0])
            Answer2.setText(QuestionsAnswers.AllAnswers[0][1])
            Answer3.setText(QuestionsAnswers.AllAnswers[0][2])
            Answer4.setText(QuestionsAnswers.AllAnswers[0][3])
        }


        nextButton = findViewById(R.id.next_button)
        nextButton.setOnClickListener{view: View ->
            // push answer info in onNextClick!!
            nextButtonClicks++
            QuestionText.setText(QuestionsAnswers.Questions[nextButtonClicks])
            Answer1.setText(QuestionsAnswers.AllAnswers[nextButtonClicks][0])
            Answer2.setText(QuestionsAnswers.AllAnswers[nextButtonClicks][1])
            Answer3.setText(QuestionsAnswers.AllAnswers[nextButtonClicks][2])
            Answer4.setText(QuestionsAnswers.AllAnswers[nextButtonClicks][3])
            onNextClick(view)
        }

        answerRadioGroup = findViewById(R.id.answer_radio_group)

        for (radioBtn in answerRadioGroup.children) {
            radioBtn.setOnClickListener(this::onAnswerSelected)
        }
    }

    private fun onNextClick(view: View){
        // make sure an answer is selected before we refresh activity!
            nextQuestion(view)

            if (nextButtonClicks == 10){
                // if they have answered 10 questions, then start the results activity
                val intent = Intent(this, ResultActivity::class.java)
                startActivity(intent)
            }
            else{
                nextQuestion(view)
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


    private fun nextQuestion(view: View){
        selectedAnswers.add(currentAnswer)
        // reset
    }


}