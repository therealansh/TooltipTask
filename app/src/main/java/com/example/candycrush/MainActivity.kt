package com.example.candycrush

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.Window
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var playBtn: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_main)
        playBtn = findViewById(R.id.playBtn)
        playBtn.setOnClickListener {
            val gamePlay = Intent(this, Game::class.java)
            startActivity(gamePlay)
        }
    }

    override fun onStart() {
        super.onStart()
        val alert = showDialog()
        alert.show()
    }

    private fun showDialog(): AlertDialog {
        val dialog = AlertDialog.Builder(this@MainActivity)
        dialog.setCancelable(false)
        dialog.setTitle("Kings Candy Crush")
        dialog.setMessage("This is a custom Dialog box. Proceed to Play?")
        dialog.setPositiveButton("Play") { dialog, id ->
            dialog.dismiss()
        }
            .setNegativeButton("View T&C") { dialog, which ->
                dialog.cancel()
            }
        val alert = dialog.create()
        return alert
    }
}