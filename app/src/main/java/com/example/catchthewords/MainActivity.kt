package com.example.catchthewords

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
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

        // findID
        val btnStart: Button = findViewById(R.id.btnStart)
        val btnRate: Button = findViewById(R.id.btnRate)

        // action button
        btnStart.setOnClickListener {
            val intent = Intent(this, TopicActivity::class.java)
            intent.putExtra("TOPIC_ID", "Food") // Pass the message
            startActivity(intent)
        }

        btnRate.setOnClickListener {
            var dialog_var = RateFragment()
            dialog_var.show(supportFragmentManager, "Custom Dialog")
        }
    }

    // load menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.my_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // action menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_home_page -> {
                Toast.makeText(this, "Item Homepage", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return true
            }

            R.id.item_topic1 -> {
                Toast.makeText(this, "Topic 1 selected", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, TopicActivity::class.java)
                intent.putExtra("TOPIC_ID", "Food") // Pass the message
                startActivity(intent)
                return true
            }

            R.id.item_topic2 -> {
                Toast.makeText(this, "Topic 2 selected", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, TopicActivity::class.java)
                intent.putExtra("TOPIC_ID", "Object") // Pass the message
                startActivity(intent)
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }

    //action dialog fragment
    fun receiveFeedback(feedback: String){
        val txtRate : TextView = findViewById(R.id.txtRate)
        txtRate.text = feedback;
    }
}