package com.zybooks.whatsthevibe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.view.children

class QuizActivity : AppCompatActivity() {

    private lateinit var answerRadioGroup : RadioGroup
    private lateinit var nextButton : Button
    private var currentAnswer : String = "No Answer"
    private lateinit var QuestionText : TextView
    private lateinit var Answer1 : RadioButton
    private lateinit var Answer2 : RadioButton
    private lateinit var Answer3 : RadioButton
    private lateinit var Answer4 : RadioButton
    private var selectedAnswers = arrayListOf<String>()
    private var nextButtonClicks : Int = 0
    private val QuestionsAnswers = QuestionsAnswer()
    private var currentIndex : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)


        //QuestionText.setText(QuestionsAnswer.Questions[0])
        QuestionText = findViewById(R.id.question_text)
        Answer1 = findViewById(R.id.answer1)
        Answer2 = findViewById(R.id.answer2)
        Answer3 = findViewById(R.id.answer3)
        Answer4 = findViewById(R.id.answer4)

        QuestionText.setText(QuestionsAnswers.Questions[0])
        Answer1.setText(QuestionsAnswers.AllAnswers[0][0])
        Answer2.setText(QuestionsAnswers.AllAnswers[0][1])
        Answer3.setText(QuestionsAnswers.AllAnswers[0][2])
        Answer4.setText(QuestionsAnswers.AllAnswers[0][3])

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
        Log.d("Tag", "Current Answer in Next Button $currentAnswer")
        if (currentAnswer == "No Answer"){
            Toast.makeText(this, "Please Select An Answer", Toast.LENGTH_SHORT).show()
        }
        else {
            nextButtonClicks++
            var currentLength = selectedAnswers.size
            if (selectedAnswers.size != 0) {
                if (selectedAnswers[currentLength - 1] == currentAnswer && currentLength != 0) {
                    currentAnswer = QuestionsAnswers.AllAnswers[currentLength][currentIndex]
                    Log.d("TAG", "Same button as last time, current answer is $currentAnswer")
                }
            }
            selectedAnswers.add(currentAnswer)
            try {
                QuestionText.setText(QuestionsAnswers.Questions[nextButtonClicks])
                Answer1.setText(QuestionsAnswers.AllAnswers[nextButtonClicks][0])
                Answer2.setText(QuestionsAnswers.AllAnswers[nextButtonClicks][1])
                Answer3.setText(QuestionsAnswers.AllAnswers[nextButtonClicks][2])
                Answer4.setText(QuestionsAnswers.AllAnswers[nextButtonClicks][3])

                if (nextButtonClicks == 9) {
                    nextButton.setText("Get Results!")
                }
            } catch (e: Exception) {
                val intent = Intent(this, ResultActivity::class.java)
                Log.d("TAG", "All Answers before result? $selectedAnswers")
                intent.putExtra("All Answers", selectedAnswers)
                startActivity(intent)
            }
        }
    }

    private fun onAnswerSelected(view: View) {
        currentAnswer = when (view.id) {
            R.id.answer1 -> QuestionsAnswers.AllAnswers[nextButtonClicks][0]
            R.id.answer2 -> QuestionsAnswers.AllAnswers[nextButtonClicks][1]
            R.id.answer3 -> QuestionsAnswers.AllAnswers[nextButtonClicks][2]
            R.id.answer4 -> QuestionsAnswers.AllAnswers[nextButtonClicks][3]
            else -> "No Answer"
        }

        currentIndex = when(view.id){
            R.id.answer1 -> 0
            R.id.answer2 -> 1
            R.id.answer3 -> 2
            R.id.answer4 -> 3
            else -> 0
        }

        Log.d("Tag", "Current Answer in Selected $currentAnswer")
    }


    private fun nextQuestion(view: View){
        selectedAnswers.add(currentAnswer)
        // reset
    }


}