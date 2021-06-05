package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class SecondFragment : Fragment() {

    private lateinit var btn_go_to_first_fragment: Button
    private lateinit var btn_go_to_third_fragment: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        println(arguments?.getString("key"))

        val view: View= inflater.inflate(R.layout.fragment_second, container, false)
        btn_go_to_first_fragment=view.findViewById(R.id.btn_go_to_first_fragment)
        btn_go_to_first_fragment.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_secondFragment_to_firstFragment)
        }

        btn_go_to_third_fragment=view.findViewById(R.id.btn_go_to_third_fragment)
        btn_go_to_third_fragment.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_secondFragment_to_thirdFragment)
        }
        return view
    }
}