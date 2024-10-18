package com.lakshay.notes

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NoteDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_detail)

        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")

        val tvNoteTitle = findViewById<TextView>(R.id.tvNoteTitle)
        val tvNoteDescription = findViewById<TextView>(R.id.tvNoteDescription)

        tvNoteTitle.text = title
        tvNoteDescription.text = description

        findViewById<Button>(R.id.btnGoBack).setOnClickListener {
            finish()
        }
    }
}
