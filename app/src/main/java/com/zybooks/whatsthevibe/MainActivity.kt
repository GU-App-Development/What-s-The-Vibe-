package com.zybooks.whatsthevibe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var beginButton : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        beginButton = findViewById(R.id.begin_button)
        beginButton.setOnClickListener{view: View ->
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }
    }
}