package com.example.catchthewords

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // hide actionbar on activity_main
        getSupportActionBar()?.hide()

        // findID
        val btnRate: Button = findViewById(R.id.btnRate)
        val imgPlayBtn: ImageView = findViewById(R.id.imagePlayBtn)

        // action button
        imgPlayBtn.setOnClickListener {
            val intent = Intent(this, TopicActivity::class.java)
            intent.putExtra("TOPIC_ID", "Food") // Pass the message
            startActivity(intent)
        }

        btnRate.setOnClickListener {
            var dialog_var = RateFragment()
            dialog_var.show(supportFragmentManager, "Custom Dialog")
        }
    }

    //action dialog fragment
    fun receiveFeedback(feedback: String){
        val txtRate : TextView = findViewById(R.id.txtRate)
        txtRate.text = feedback;
    }
}