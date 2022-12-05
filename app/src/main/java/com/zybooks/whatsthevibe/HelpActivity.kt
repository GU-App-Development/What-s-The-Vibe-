package com.zybooks.whatsthevibe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HelpActivity : AppCompatActivity() {

    private lateinit var backButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)
        backButton = findViewById(R.id.back_button)
        backButton.setOnClickListener{view: View ->
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }


}