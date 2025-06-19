package za.ac.iie.practicumexam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val btnReturn =findViewById<Button>(R.id.btnReturn)
        val btnCalculate =findViewById<Button>(R.id.btnCalculate)
        val listView = findViewById<ListView>(R.id.listView)

        val edtSongTitle = intent.getStringArrayListExtra("Song Title")?: arrayListOf()
        val edtRating = intent.getStringArrayListExtra("Ratings")?: arrayListOf()

        btnReturn.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}