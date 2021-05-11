package com.example.slidablemenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.slidablemenu.databinding.FragmentHelpBinding

class HelpFragment: Fragment(R.layout.fragment_help){

//    inflating the layout with onViewCreated fun

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val binding = FragmentHelpBinding.bind(view)

        binding.apply {
            btnHelp.setOnClickListener {
                val text = etHelp.text.toString().trim()
                tvHelp.text = text

                etHelp.text?.clear()
                Toast.makeText(context, "text changed to $text", Toast.LENGTH_SHORT).show()
            }
        }
        super.onViewCreated(binding.root, savedInstanceState)
    }
}