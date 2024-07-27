package com.example.catchthewords

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TopicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.topic_layout)

        // Change color action bar
        val actionBar = supportActionBar
        actionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#C2B280")))

        // findID
        val btnQ1: Button = findViewById(R.id.btnQ1)
        val btnQ2: Button = findViewById(R.id.btnQ2)
        val btnQ3: Button = findViewById(R.id.btnQ3)
        val btnQ4: Button = findViewById(R.id.btnQ4)
        val btnQ5: Button = findViewById(R.id.btnQ5)

        val txtTopic: TextView = findViewById(R.id.txtTopic)
        val rootView: ConstraintLayout = findViewById(R.id.rootView)

        // receive
        val bundle: Bundle? = intent.extras
        val topic = bundle!!.getString("TOPIC_ID")

        if ("food".equals(topic.toString(),ignoreCase=true) == true){
            rootView.setBackgroundResource(R.drawable.food_background)
        }
        if ("object".equals(topic.toString(),ignoreCase=true) == true){
            rootView.setBackgroundResource(R.drawable.object_background)
        }

        // request
        txtTopic.text = topic

        // button Action
        btnQ1.setOnClickListener {
            startQuestionActivity(1,topic.toString())
        }

        btnQ2.setOnClickListener {
            startQuestionActivity(2,topic.toString())
        }

        btnQ3.setOnClickListener {
            startQuestionActivity(3,topic.toString())
        }

        btnQ4.setOnClickListener {
            startQuestionActivity(4,topic.toString())
        }

        btnQ5.setOnClickListener {
            startQuestionActivity(5,topic.toString())
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
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return true
            }

            R.id.item_topic1 -> {
                val intent = Intent(this, TopicActivity::class.java)
                intent.putExtra("TOPIC_ID", "Food") // Pass the message
                startActivity(intent)
                return true
            }

            R.id.item_topic2 -> {
                val intent = Intent(this, TopicActivity::class.java)
                intent.putExtra("TOPIC_ID", "Object") // Pass the message
                startActivity(intent)
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }

    // other functions
    fun startQuestionActivity(questionID: Int, topicID: String) {
        val intent = Intent(this, QuestionActivity::class.java)
        intent.putExtra("QUESTION_ID", questionID) // Pass the question ID
        intent.putExtra("TOPIC_ID", topicID) // Pass the message
        startActivity(intent)
    }
}