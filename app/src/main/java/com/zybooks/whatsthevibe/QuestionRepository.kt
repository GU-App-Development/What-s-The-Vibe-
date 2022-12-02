package com.zybooks.whatsthevibe

import android.R
import android.content.Context


class QuestionRepository private constructor(context: Context) {

    var bandList: MutableList<QuestionsandAnswers> = mutableListOf()

    companion object {
        private var instance: QuestionRepository? = null

        fun getInstance(context: Context): QuestionRepository {
            if (instance == null) {
                instance = QuestionRepository(context)
            }
            return instance!!
        }
    }

    init {
        val Questions = context.resources.getStringArray(R.array.Questions)
        val AllAnswers = context.resources.getStringArray(R.array.AllAnswers)
        for (i in Questions.indices) {
             val temp = AllAnswers[0]
            bandList.add(QuestionsandAnswers(i + 1, Questions[i], AllAnswers[i]))
        }
    }

    fun getBand(bandId: Int): QuestionsandAnswers? {
        return bandList.find { it.id == bandId }
    }
}