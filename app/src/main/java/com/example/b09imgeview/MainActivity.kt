package com.example.b09imgeview

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.OnApplyWindowInsetsListener
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById<View?>(R.id.main),
            OnApplyWindowInsetsListener { v: View?, insets: WindowInsetsCompat? ->
                val systemBars = insets!!.getInsets(WindowInsetsCompat.Type.systemBars())
                v!!.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            })

        val imgView = findViewById<ImageView>(R.id.imgView)
        val button = findViewById<Button>(R.id.Button)

        val avatares = listOf(
            R.drawable.avatar1,
            R.drawable.avatar2,
            R.drawable.avatar3
        )
        var indiceActual = 0

        button.setOnClickListener {
            imgView.setImageResource(avatares[indiceActual])

            indiceActual = (indiceActual + 1) % avatares.size
        }
    }
}