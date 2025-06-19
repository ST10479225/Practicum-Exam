package za.ac.iie.practicumexam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val songtitle = arrayListOf<String>()
    private val artistname = arrayListOf<String>()
    private val rating = arrayListOf<String>()
    private val comments = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        fun initializeSampleData(){
            songtitle.addAll(listOf("We paid", "Headlines", "Dandelion", "We pray for more"))
            artistname.addAll(listOf("Lil baby", "Drake", "Tevin Campbell", "Ntokoza Mbambo"))
            rating.addAll(listOf("3","5","2","1"))
            comments.addAll(listOf("Rap","hiphop","Love song","Gospel"))
        }

        val edtSongTitle = findViewById<EditText>(R.id.edtSongTitle)
        val edtArtistName = findViewById<EditText>(R.id.edtArtistName)
        val edtRating = findViewById<EditText>(R.id.edtRating)
        val edtComments = findViewById<EditText>(R.id.edtComments)

        val btnAddToPlaylist = findViewById<Button>(R.id.btnAddToPlaylist)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnExit = findViewById<Button>(R.id.btnExit)

        btnAddToPlaylist.setOnClickListener{
            val edtSongTitle = edtSongTitle.text.toString()
            val edtArtistName = edtArtistName.text.toString()
            val edtRating = edtRating.text.toString()
            val edtComments = edtComments.text.toString()

            if (edtSongTitle.isEmpty() || edtArtistName.isEmpty() || edtRating.isEmpty() || edtComments.isEmpty()){
                Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT ).show()
            }else {
                try {
                    val edtRating = edtRating.toInt()
                    songtitle.add(edtSongTitle)
                    artistname.add(edtArtistName)
                    comments.add(edtComments)

                    Toast.makeText(this, "Song added", Toast.LENGTH_LONG).show()
                } catch (e: NumberFormatException) {
                  Toast.makeText(this,"Rating must be a number", Toast.LENGTH_LONG).show()

                }
            }
        }

        btnNext.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}