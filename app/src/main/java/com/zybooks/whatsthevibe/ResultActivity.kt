package com.zybooks.whatsthevibe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.Math

class ResultActivity : AppCompatActivity() {

    val SongPlaylistGeneratorObject = SongPlaylistGenerator()
    private lateinit var SongNameText : TextView
    private lateinit var ShareButton : Button
    private lateinit var RestartButton : Button
    private lateinit var randomSong : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        SongNameText = findViewById(R.id.song_name_text)
        val values = (0.. 9).toList()
        val randomIndex = values.random()
        randomSong = SongPlaylistGeneratorObject.AllSongs[randomIndex]
        SongNameText.setText(randomSong)

        ShareButton = findViewById(R.id.share_button)
        ShareButton.setOnClickListener{view: View ->
            onShareButtonClick(view)
        }
        RestartButton = findViewById(R.id.restart_button)
        RestartButton.setOnClickListener{view: View ->
            onRestartButtonClick(view)
        }
    }

    private fun onShareButtonClick(view: View){
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, "What's the Vibe Results")
        intent.putExtra(Intent.EXTRA_TEXT, "Hey Check Out $randomSong! I found it on the What's the Vibe App!")

        if (intent.resolveActivity(packageManager) != null) {
            val chooser = Intent.createChooser(intent, "Share URL")
            startActivity(chooser)
        }
    }

    private fun onRestartButtonClick(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}