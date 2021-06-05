package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FirstFragment : Fragment() {

    private lateinit var btn_go_to_second_fragment: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view: View= inflater.inflate(R.layout.fragment_first, container, false)
        btn_go_to_second_fragment=view.findViewById(R.id.btn_go_to_second_fragment)
        btn_go_to_second_fragment.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("key", "Hello")
            (activity as MainActivity)
                .navController.navigate(R.id.action_firstFragment_to_secondFragment,
                bundle)
        }
        return view
    }


}