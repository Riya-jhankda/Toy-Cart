package com.example.toy

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.*
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val item = findViewById<ConstraintLayout>(R.id.item)
        val item2 = findViewById<ConstraintLayout>(R.id.item2)
        val item3 = findViewById<ConstraintLayout>(R.id.item3)
        val item4 = findViewById<ConstraintLayout>(R.id.item4)
        val fcont = findViewById<FrameLayout>(R.id.fcont)
        val bundle = Bundle()
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navview = findViewById<NavigationView>(R.id.nav_view)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        var mAuth = FirebaseAuth.getInstance()

        setSupportActionBar(toolbar)

        val headerView = navview.getHeaderView(0)
        val heyText = headerView.findViewById<TextView>(R.id.hey_text)
        heyText.text = "Hey There,\nAkriti"+ mAuth.currentUser?.displayName.toString()


       // heyText.setText()
        val toy1 = toys(findViewById<TextView>(R.id.title).text.toString())
        toy1.description = findViewById<TextView>(R.id.des).text.toString()
        toy1.price = findViewById<ImageView>(R.id.item_img).drawable

        Toast.makeText(this,""+toy1.price,Toast.LENGTH_SHORT).show()


        val toy2 = toys(findViewById<TextView>(R.id.title2).text.toString())
        toy2.description = findViewById<TextView>(R.id.des2).text.toString()
        toy2.price = findViewById<ImageView>(R.id.item_img2).drawable

        val toy3 = toys(findViewById<TextView>(R.id.title3).text.toString())
        toy3.description = findViewById<TextView>(R.id.des3).text.toString()
        toy3.price = findViewById<ImageView>(R.id.item_img3).drawable

        val toy4 = toys(findViewById<TextView>(R.id.title4).text.toString())
        toy4.description = findViewById<TextView>(R.id.des4).text.toString()
        toy4.price = findViewById<ImageView>(R.id.item_img4).drawable

        item.setOnClickListener{
              bundle.putParcelable("details", toy1)

//            bundle.putString("test", "test succes")
            Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show()

            fcont.visibility = View.VISIBLE
            fcont.isClickable = true

            supportFragmentManager.commit{
                setReorderingAllowed(true)
                add<toy_page>(R.id.fcont2,null,bundle)
                addToBackStack("toypage")
            }
            supportFragmentManager.setFragmentResult("requestKey", bundle)
        }

        item2.setOnClickListener{
            bundle.putParcelable("details", toy2)
//            bundle.putString("test", "test succes")
            Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show()

            fcont.visibility = View.VISIBLE
            fcont.isClickable = true

            supportFragmentManager.commit{
                setReorderingAllowed(true)
                add<toy_page>(R.id.fcont2,null,bundle)
                addToBackStack("toypage")
            }
            supportFragmentManager.setFragmentResult("requestKey", bundle)
        }

        item3.setOnClickListener{
            bundle.putParcelable("details", toy3)
//            bundle.putString("test", "test succes")
            Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show()

            fcont.visibility = View.VISIBLE
            fcont.isClickable = true

            supportFragmentManager.commit{
                setReorderingAllowed(true)
                add<toy_page>(R.id.fcont2,null,bundle)
                addToBackStack("toypage")
            }
            supportFragmentManager.setFragmentResult("requestKey", bundle)
        }

        item4.setOnClickListener{
            bundle.putParcelable("details", toy4)
//            bundle.putString("test", "test succes")
            Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show()

            fcont.visibility = View.VISIBLE
            fcont.isClickable = true

            supportFragmentManager.commit{
                setReorderingAllowed(true)
                add<toy_page>(R.id.fcont2,null,bundle)
                addToBackStack("toypage")
            }
            supportFragmentManager.setFragmentResult("requestKey", bundle)
        }
    }



}