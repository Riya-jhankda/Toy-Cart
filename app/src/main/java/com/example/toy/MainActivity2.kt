package com.example.toy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val title = findViewById<TextView>(R.id.toytitle2)
        val des = findViewById<TextView>(R.id.toydes) as TextView
        val image = findViewById<ImageView>(R.id.toyimg) as ImageView

        val intent = intent
        val test = intent.getStringExtra("test")
        Toast.makeText(this, ""+test, Toast.LENGTH_SHORT).show()
        val bund: Bundle? =  intent.getBundleExtra("details")
        if (bund != null) {
           val toy = bund.getParcelable<toys>("details")
            if (toy != null) {

                title.setText(toy.title)
                des.setText(toy.description)
                toy.price?.let { image.setImageDrawable(it) }
                Toast.makeText(this, ""+toy.price.toString(), Toast.LENGTH_SHORT).show()

            }
        }


    }
}