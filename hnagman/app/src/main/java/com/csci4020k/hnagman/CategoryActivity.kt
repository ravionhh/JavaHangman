package com.csci4020k.hnagman

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button

class CategoryActivity : AppCompatActivity() {


        companion object {
            private var value: String = ""
            fun getValue():String {
                return value;

        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val carsButton: Button = findViewById(R.id.carsButton)
        val animalsButton: Button = findViewById(R.id.animalsButton)
        val moviesButton: Button = findViewById(R.id.moviesButton)
        val foodsButton: Button = findViewById(R.id.foodsButton)
        val brandsButton: Button = findViewById(R.id.brandsButton)



        carsButton.setOnClickListener {
            value = carsButton.text.toString().lowercase()
            val hangmanIntent = Intent(this, HangmanActivity::class.java)
            startActivity(hangmanIntent)
        }
        moviesButton.setOnClickListener {
            value = moviesButton.text.toString().lowercase()
            val hangmanIntent = Intent(this, HangmanActivity::class.java)
            startActivity(hangmanIntent)
        }
        animalsButton.setOnClickListener {
            value = animalsButton.text.toString().lowercase()
            val hangmanIntent = Intent(this, HangmanActivity::class.java)
            startActivity(hangmanIntent)
        }
        brandsButton.setOnClickListener {
            value = brandsButton.text.toString().lowercase()
            val hangmanIntent = Intent(this, HangmanActivity::class.java)
            startActivity(hangmanIntent)
        }
        foodsButton.setOnClickListener {
            value = foodsButton.text.toString().lowercase()
            val hangmanIntent = Intent(this, HangmanActivity::class.java)
            startActivity(hangmanIntent)
        }

    }
}