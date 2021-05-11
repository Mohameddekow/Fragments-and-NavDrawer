package com.example.slidablemenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.slidablemenu.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false )

        binding.apply {
            btnHome.setOnClickListener {
                val text = etHome.text.toString()
                tvHome.text = text
                etHome.text?.clear()

                etHome.text?.clear()
                Toast.makeText(context, "text changed to $text", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

}