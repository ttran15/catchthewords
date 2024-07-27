package com.example.catchthewords

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
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

class QuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.question_layout)

        // Change color action bar
        val actionBar = supportActionBar
        actionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#568f56")))

        // find ID
        val btnCheck: Button = findViewById(R.id.btnCheck)
        val btnHint: Button = findViewById(R.id.btnHint)
        val btnBack: Button = findViewById(R.id.btnBack)

        val edAnswer: EditText = findViewById(R.id.edAnswer)
        val txtResult: TextView = findViewById(R.id.txtResult)

        val imgView: ImageView = findViewById(R.id.imgView)

        // receive
        val questionID = intent.getIntExtra("QUESTION_ID", -1)
        val bundle: Bundle? = intent.extras
        val topicID = bundle!!.getString("TOPIC_ID")

        // response
        val img = getImageByID(questionID,topicID.toString())
        imgView.setImageResource(img)

        val answer = getAnswerByID(questionID,topicID.toString())

        val hint = getHintByID(questionID,topicID.toString())

        // action button
        btnCheck.setOnClickListener {
            val type_answer = edAnswer.text.toString()
            if (type_answer.equals(answer, ignoreCase = true)){
                txtResult.text = "Correct!"
                txtResult.setTextColor(Color.parseColor("#228B22"))
            } else {
                txtResult.text = "Try again -_-"
                txtResult.setTextColor(Color.parseColor("#F44336"))
            }
        }

        btnHint.setOnClickListener {
            var dialog_notification = PopupFragment()
            val args = Bundle().apply {
                putString("arg_message", hint)
            }
            dialog_notification.arguments = args
            dialog_notification.show(supportFragmentManager,"Notification")
        }

        btnBack.setOnClickListener {
            val intent = Intent(this, TopicActivity::class.java)
            intent.putExtra("TOPIC_ID", topicID) // Pass the message
            startActivity(intent)
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
    fun getImageByID(questionID: Int, topicID: String): Int {
        if ((questionID == 1) && (topicID == "Food")){
            return R.drawable.img1
        }
        else if ((questionID == 2) && (topicID == "Food")){
            return R.drawable.img2
        }
        else if ((questionID == 3) && (topicID == "Food")){
            return R.drawable.img3
        }
        else if ((questionID == 4) && (topicID == "Food")){
            return R.drawable.img4
        }
        else if ((questionID == 5) && (topicID == "Food")){
            return R.drawable.img5
        }
        else if ((questionID == 1) && (topicID == "Object")){
            return R.drawable.img6
        }
        else if ((questionID == 2) && (topicID == "Object")){
            return R.drawable.img7
        }
        else if ((questionID == 3) && (topicID == "Object")){
            return R.drawable.img8
        }
        else if ((questionID ==4) && (topicID == "Object")){
            return R.drawable.img9
        }
        else if ((questionID == 5) && (topicID == "Object")){
            return R.drawable.img10
        }
        else{
            return -1
        }
    }

    fun getAnswerByID(questionID: Int, topicID:String): String {
        if ((questionID == 1) && (topicID == "Food")){
            return "watermelon"
        }
        else if ((questionID == 2) && (topicID == "Food")){
            return "pancake"
        }
        else if ((questionID == 3) && (topicID == "Food")){
            return "hot dog"
        }
        else if ((questionID == 4) && (topicID == "Food")){
            return "milk tea"
        }
        else if ((questionID == 5) && (topicID == "Food")){
            return "rice"
        }
        else if ((questionID == 1) && (topicID == "Object")){
            return "school bag"
        }
        else if ((questionID == 2) && (topicID == "Object")){
            return "spaceship"
        }
        else if ((questionID == 3) && (topicID == "Object")){
            return "rainbow"
        }
        else if ((questionID ==4) && (topicID == "Object")){
            return "train"
        }
        else if ((questionID == 5) && (topicID == "Object")){
            return "sunglasses"
        }
        else{
            return ""
        }
    }

    fun getHintByID(questionID: Int, topicID:String): String {
        if ((questionID == 1) && (topicID == "Food")){
            return "a large round fruit with hard green skin, red flesh, and black seeds"
        }
        else if ((questionID == 2) && (topicID == "Food")){
            return "a thin flat round cake made from flour, milk, and eggs"
        }
        else if ((questionID == 3) && (topicID == "Food")){
            return "a cooked sausage in a long piece of bread"
        }
        else if ((questionID == 4) && (topicID == "Food")){
            return "a beverage containing a combination of milk and tea"
        }
        else if ((questionID == 5) && (topicID == "Food")){
            return "a cereal grass that is cultivated extensively in warm climates"
        }
        else if ((questionID == 1) && (topicID == "Object")){
            return "a bag for carrying books and school supplies"
        }
        else if ((questionID == 2) && (topicID == "Object")){
            return "a vehicle for carrying people through space"
        }
        else if ((questionID == 3) && (topicID == "Object")){
            return "a large curve of different colours that can appear in the sky"
        }
        else if ((questionID ==4) && (topicID == "Object")){
            return "a series of connected vehicles that run along a railway track"
        }
        else if ((questionID == 5) && (topicID == "Object")){
            return "a thing that people wear to protect their eyes when the sun is very bright"
        }
        else{
            return ""
        }
    }
}