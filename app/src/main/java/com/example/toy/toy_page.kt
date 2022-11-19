package com.example.toy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class toy_page : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //val binding = DataBindingUtil.inflate<FragmentToyPageBinding>(inflater,R.layout.fragment_toy_page,container,false)
        return inflater.inflate(R.layout.fragment_toy_page,container, false)
    }

}