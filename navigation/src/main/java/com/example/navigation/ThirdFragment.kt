package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class ThirdFragment : Fragment() {

    private lateinit var btn_go_to_second_fragment: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View= inflater.inflate(R.layout.fragment_third, container, false)
        btn_go_to_second_fragment=view.findViewById(R.id.btn_go_to_second_fragment)
        btn_go_to_second_fragment.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_thirdFragment_to_secondFragment)
        }
        return view
    }

}