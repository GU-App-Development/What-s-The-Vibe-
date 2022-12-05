package com.zybooks.whatsthevibe

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import java.security.AccessController.getContext

class MainActivity : AppCompatActivity() {

    private lateinit var beginButton : Button
    private lateinit var helpButton : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        beginButton = findViewById(R.id.begin_button)
        beginButton.setOnClickListener{view: View ->
            val quizIntent = Intent(this, QuizActivity::class.java)
            startActivity(quizIntent)
        }

        helpButton = findViewById(R.id.help_button)
        helpButton.setOnClickListener{view: View ->
            val helpIntent = Intent(this, HelpActivity::class.java)
            startActivity(helpIntent)
        }
    }
}