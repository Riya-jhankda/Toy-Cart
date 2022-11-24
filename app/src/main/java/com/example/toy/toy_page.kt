package com.example.toy

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener


class toy_page : Fragment() {
    var bundl = arguments;
    var addToCart : AppCompatButton? = null
    var buyNow : AppCompatButton? = null


    //   val toys = bundle!!.getString("details")!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //val binding = DataBindingUtil.inflate<FragmentToyPageBinding>(inflater,R.layout.fragment_toy_page,container,false)


        return inflater.inflate(R.layout.fragment_toy_page,container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFragmentResultListener("requestKey") { requestKey, bundle ->
          //  Toast.makeText(activity, ""+result, Toast.LENGTH_SHORT).show()
           var toy = bundle.getParcelable<toys>("details")
            bundl = bundle
            val des = view.findViewById<TextView>(R.id.toy_des)
            if (toy != null) {
                des.setText(toy.description)
            }
            val title = view.findViewById<TextView>(R.id.toy_title)

            val img = view.findViewById<ImageView>(R.id.toy_image)
            if (toy != null) {
                title.setText(toy.title)
            }
            if (toy != null) {
              toy.price?.let { img.setImageDrawable(it) }
                Toast.makeText(activity, ""+toy.price.toString(), Toast.LENGTH_SHORT).show()

            }

        }
        addToCart = view.findViewById(R.id.addToCart)
        buyNow = view.findViewById(R.id.buyNow)
        addToCart?.setOnClickListener{
            val fcont =  activity?.findViewById<FrameLayout>(R.id.fcont) as FrameLayout
            fcont.isClickable = false
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }
        buyNow?.setOnClickListener{
            val intent = Intent(activity, MainActivity2::class.java)
            intent.putExtra("details", bundl)
            intent.putExtra("test","test")
            startActivity(intent)
        }

    }

    override fun onDetach() {
        super.onDetach()
       val fcont =  activity?.findViewById<FrameLayout>(R.id.fcont) as FrameLayout
        fcont.isClickable = false

        //

    }

}