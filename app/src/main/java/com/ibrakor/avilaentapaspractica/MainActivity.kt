package com.example.avilaentapaspractica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.ibrakor.avilaentapaspractica.presentation.TapaActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
    }

    private fun setupView() {
        findViewById<Button>(R.id.action_avilaentapas).setOnClickListener {
            startActivity(Intent(this, TapaActivity::class.java))
        }
    }
}