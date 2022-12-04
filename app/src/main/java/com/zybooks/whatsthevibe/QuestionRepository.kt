
package com.zybooks.whatsthevibe
/*
import android.content.Context
import android.content.res.Resources
import android.util.Log


class QuestionRepository private constructor() {

    var questionAnswerList: MutableList<QuestionsandAnswers> = mutableListOf()

    companion object {
        private var instance: QuestionRepository? = null

    }

    init {

        val res : Resources = resources
        val Questions = g.getStringArray(R.array.Questions)

        val AllAnswers = context.resources.getStringArray(R.array.AllAnswers)
        for (i in Questions.indices) {
            val AnswersPerQuestion = AllAnswers.take(4)
            AllAnswers.drop(4)
            questionAnswerList.add(QuestionsandAnswers(i + 1, Questions[i], AnswersPerQuestion))
            Log.d("TAG", questionAnswerList[i].Answers[1])
        }
    }

    fun getBand(bandId: Int): QuestionsandAnswers? {
        return questionAnswerList.find { it.id == bandId }
    }
}*/
