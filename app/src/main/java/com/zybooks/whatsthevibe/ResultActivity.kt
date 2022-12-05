package com.zybooks.whatsthevibe

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.lang.Math

class ResultActivity : AppCompatActivity() {

    val SongPlaylistGeneratorObject = SongPlaylistGenerator()
    private lateinit var SongNameText : TextView
    private lateinit var ShareButton : Button
    private lateinit var RestartButton : Button
    private lateinit var randomSong : String
    private lateinit var SongImage : ImageView

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        SongNameText = findViewById(R.id.song_name_text)

        SongImage = findViewById(R.id.result_image)


        val allAnswers = intent.getStringArrayListExtra("All Answers")
        val genre = intent.getStringExtra("Genre")

        randomSong = findSong(genre)
        SongNameText.setText(randomSong)
        Log.d("TAG", "Selected Genre was... $genre")

        // Set the image
        setImage(genre)

        ShareButton = findViewById(R.id.share_button)
        ShareButton.setOnClickListener{view: View ->
            onShareButtonClick(view)
        }
        RestartButton = findViewById(R.id.restart_button)
        RestartButton.setOnClickListener{view: View ->
            onRestartButtonClick(view)
        }
    }

    private fun findSong(Genre : String?): String {
        val Song = when (Genre){
            "Pop" -> SongPlaylistGeneratorObject.PopSongs.asSequence().shuffled().take(1).toList()
            "Country" -> SongPlaylistGeneratorObject.CountrySongs.asSequence().shuffled().take(1).toList()
            "ClassicRock" -> SongPlaylistGeneratorObject.ClassicRockSongs.asSequence().shuffled().take(1).toList()
            "Indie" -> SongPlaylistGeneratorObject.IndieSongs.asSequence().shuffled().take(1).toList()
            "Jazz" -> SongPlaylistGeneratorObject.JazzSongs.asSequence().shuffled().take(1).toList()
            "EDM" -> SongPlaylistGeneratorObject.EDMSongs.asSequence().shuffled().take(1).toList()
            "Holiday" -> SongPlaylistGeneratorObject.HolidaySongs.asSequence().shuffled().take(1).toList()
            "HipHop" -> SongPlaylistGeneratorObject.HipHopSongs.asSequence().shuffled().take(1).toList()
            else -> SongPlaylistGeneratorObject.PopSongs.asSequence().shuffled().take(1).toList()
        }

        return Song[0]
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

    private fun setImage(genre: String?) {
        when (genre) {
            "Pop" -> SongImage.setImageResource(R.drawable.pop_music)
            "Country" -> SongImage.setImageResource(R.drawable.country_music)
            "ClassicRock" -> SongImage.setImageResource(R.drawable.rock_music)
            "Indie" -> SongImage.setImageResource(R.drawable.indie_music)
            "Jazz" -> SongImage.setImageResource(R.drawable.jazz_music)
            "EDM" -> SongImage.setImageResource(R.drawable.edm_music)
            "Holiday" -> SongImage.setImageResource(R.drawable.holiday_music)
            "HipHop" -> SongImage.setImageResource(R.drawable.hip_hop_music)
            else -> SongImage.setImageResource(R.drawable.pop_music)
        }
    }

}