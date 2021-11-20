package com.example.candycrush

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.core.os.HandlerCompat.postDelayed

class Game : AppCompatActivity() {
    private lateinit var tooltip1:ImageView
    private lateinit var tooltip2:ImageView
    private lateinit var tooltip3:ImageView
    private lateinit var gameArea: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        tooltip1 = findViewById<ImageView>(R.id.tooltip1)
        tooltip2 = findViewById<ImageView>(R.id.tooltip2)
        tooltip3 = findViewById<ImageView>(R.id.tooltip3)
        gameArea = findViewById<Button>(R.id.game)
        tooltip3.visibility = View.INVISIBLE
        tooltip2.visibility=View.INVISIBLE
        tooltip1.visibility = View.VISIBLE

        gameArea.setOnClickListener{
            tooltip1.visibility = View.INVISIBLE
            tooltip2.visibility = View.VISIBLE
            Handler(Looper.getMainLooper()).postDelayed({
                tooltip2.visibility = View.INVISIBLE
                tooltip3.visibility = View.VISIBLE
            }, 2000)
        }

    }
}