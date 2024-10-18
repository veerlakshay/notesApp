package com.lakshay.notes

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WhoAmIActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_who_am_i)

        findViewById<Button>(R.id.btnGoBackMain).setOnClickListener {
            finish()
        }
    }
}
