package com.example.toy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val item = findViewById<ConstraintLayout>(R.id.item)
        val item2 = findViewById<ConstraintLayout>(R.id.item2)
        val item3 = findViewById<ConstraintLayout>(R.id.item3)
        val item4 = findViewById<ConstraintLayout>(R.id.item4)

        val toy1 = toys(findViewById<TextView>(R.id.title).text.toString())
        toy1.description = findViewById<TextView>(R.id.des).text.toString()
        toy1.price = findViewById<TextView>(R.id.price).text.toString()

        val toy2 = toys(findViewById<TextView>(R.id.title2).text.toString())
        toy1.description = findViewById<TextView>(R.id.des2).text.toString()
        toy1.price = findViewById<TextView>(R.id.price2).text.toString()

        val toy3 = toys(findViewById<TextView>(R.id.title3).text.toString())
        toy1.description = findViewById<TextView>(R.id.des3).text.toString()
        toy1.price = findViewById<TextView>(R.id.price3).text.toString()

        val toy4 = toys(findViewById<TextView>(R.id.title4).text.toString())
        toy1.description = findViewById<TextView>(R.id.des4).text.toString()
        toy1.price = findViewById<TextView>(R.id.price4).text.toString()

        item.setOnClickListener{
            val intent = Intent()
        }
    }

}