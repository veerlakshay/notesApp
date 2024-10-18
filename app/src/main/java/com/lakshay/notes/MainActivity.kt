package com.lakshay.notes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         lateinit var recyclerView: RecyclerView
         lateinit var adapter: NotesAdapter
         val notesList = mutableListOf<Note>()

        val editNoteTitle = findViewById<EditText>(R.id.editNoteTitle)
        val editNoteDescription = findViewById<EditText>(R.id.editNoteDescription)
        val editNotePriority = findViewById<EditText>(R.id.editNotePriority)
        val btnAddNote = findViewById<Button>(R.id.btnAddNote)
        val btnWhoAmI = findViewById<Button>(R.id.btnWhoAmI)

        recyclerView = findViewById(R.id.recyclerViewNotes)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = NotesAdapter(notesList) { note ->
            val intent = Intent(this, NoteDetailActivity::class.java)
            intent.putExtra("title", note.title)
            intent.putExtra("description", note.description)
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        notesList.addAll(
            listOf(
                Note("Meeting Note", "Meeting is at 1pm", "Low"),
                Note("Sleep Well Note", "Sleep by 10:00 pm", "High"),
                Note("Get Grocery", "Banana, apple, grapes", "Low"),
                Note("Exam Note", "Exam starts at 7pm", "Low")
            )
        )
        adapter.notifyDataSetChanged()


        btnAddNote.setOnClickListener {
            val title = editNoteTitle.text.toString()
            val description = editNoteDescription.text.toString()
            val priority = editNotePriority.text.toString()

            if (title.isNotEmpty() && description.isNotEmpty() && priority.isNotEmpty()) {
                val note = Note(title, description, priority)
                notesList.add(note)
                adapter.notifyItemInserted(notesList.size - 1)
            }
        }

        btnWhoAmI.setOnClickListener {
            val intent = Intent(this, WhoAmIActivity::class.java)
            startActivity(intent)
        }


    }
}












