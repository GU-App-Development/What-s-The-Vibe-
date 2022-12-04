package com.zybooks.whatsthevibe

import android.util.ArrayMap
import android.util.Log
import java.util.stream.IntStream.range

class QuestionsAnswer{

    /*public var AllAnswers = arrayListOf(arrayListOf<String>())*/
    var AllQuestions = arrayListOf<String>()
    var QuestionsforQuiz = listOf<String>()
    var AnswersforQuiz = mutableListOf(listOf<String>())

    val AllAnswers = arrayOf(
        arrayOf(
            "I'm sooooo tired",
            "I could go on a run right now",
            "50/50",
            "I'm feelin alright"
        ),
        arrayOf(
            "I just ate I'm all good",
            "Absolutely starving",
            "I could eat right now",
            "Nah, not really"
        ),
        arrayOf(
            "8-10", "11-12", "1-2", "Uhhhhhh"
        ),
        arrayOf(
            "Yeah let's get pumped!!",
            "Nah, I'm chillin right now",
            "Yea, I guess",
            "Absolutely not"),
        arrayOf(
            "Yes!",
            "Not Really",
            "I'm just trying to chill right now",
            "I guess so"
        ),
        arrayOf(
            "Give me some throwbacks!", "Something lowkey I can chill too, maybe a little sad",
            "Rap", "Something up-beat"
        ),
        arrayOf(
            "Yeah...", "Nah I'm good!", "Maybe a little", "Not really"
        ),
        arrayOf(
            "16-21", "22-30", "31-45", "46+"
        ),
        arrayOf(
            "NOPE",
            "It's about that time!!",
            "Uhh, sure?",
            "Not really feeling it"
        ),
        arrayOf(
            "Instagram", "Twitter", "Facebook", "Other"
        ),
        arrayOf(
            "11th Question", "11th Question", "11th Question", "11th Question"
        )

    )

    init {

        AllQuestions.add("How tired are you?")
        AllQuestions.add("Are you hungry?")
        AllQuestions.add("When did you go to bed last night?")
        AllQuestions.add("Do you need motivation right now?")
        AllQuestions.add("Do you like to sing along to music?")
        AllQuestions.add("What genre are you feeling right now?")
        AllQuestions.add("Are you feeling sad right now?")
        AllQuestions.add("How old are you?")
        AllQuestions.add("Are you feeling like listening to holiday music?")
        AllQuestions.add("What’s your favorite social media?")
        AllQuestions.add("11th Question")

        QuestionsforQuiz = AllQuestions.asSequence().shuffled().take(10).toList()
        AnswersforQuiz.removeAt(0)
        for (question in QuestionsforQuiz){
            val currentIndex = AllQuestions.indexOf(question)
            val currentAnswer = AllAnswers[currentIndex].toList()
            AnswersforQuiz.add(currentAnswer)
            Log.d("TAG", "Answers for Quiz at 0? $AnswersforQuiz")
        }


        /*val AnswerQuestion1 = arrayOf(
            "I'm sooooo tired",
            "I could go on a run right now",
            "50/50",
            "I'm feelin alright"
        )
        AllAnswers.add(AnswerQuestion1)
        val AnswerQuestion2 = arrayOf(
            "I just ate I'm all good",
            "Absolutely starving",
            "I could eat right now",
            "Nah, not really"
        )
        AllAnswers.add(AnswerQuestion2)
        val AnswerQuestion3 = arrayListOf<String>("8-10", "11-12", "1-2", "Uhhhhhh")
        AllAnswers.add(AnswerQuestion3)
        val AnswerQuestion4 = arrayListOf<String>(
            "Yeah let's get pumped!!",
            "Nah, I'm chillin right now",
            "Yea, I guess",
            "Absolutely not"
        )
        AllAnswers.add(AnswerQuestion4)
        val AnswerQuestion5 = arrayListOf<String>(
            "Yes!",
            "Not Really",
            "I'm just trying to chill right now",
            "I guess so"
        )
        AllAnswers.add(AnswerQuestion5)
        val AnswerQuestion6 = arrayListOf<String>(
            "Give me some throwbacks!", "Something lowkey I can chill too, maybe a little sad",
            "Rap", "Something up-beat"
        )
        AllAnswers.add(AnswerQuestion6)
        val AnswerQuestion7 =
            arrayListOf<String>("Yeah...", "Nah I'm good!", "Maybe a little", "Not really")
        AllAnswers.add(AnswerQuestion7)
        val AnswerQuestion8 = arrayListOf<String>("16-21", "22-30", "31-45", "46+")
        AllAnswers.add(AnswerQuestion8)
        val AnswerQuestion9 = arrayListOf<String>(
            "NOPE",
            "It's about that time!!",
            "Uhh, sure?",
            "Not really feeling it"
        )
        AllAnswers.add(AnswerQuestion9)
        val AnswerQuestion10 = arrayListOf<String>("Instagram", "Twitter", "Facebook", "Other")
        AllAnswers.add(AnswerQuestion10)*/
    }



}


