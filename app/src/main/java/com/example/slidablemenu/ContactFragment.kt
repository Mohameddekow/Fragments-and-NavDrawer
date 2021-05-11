package com.example.slidablemenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.slidablemenu.databinding.FragmentContactBinding

class ContactFragment: Fragment() {
    lateinit var binding: FragmentContactBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

//        you can inflate the view and bind later when initializing the binding Variable
        val view =  inflater.inflate(R.layout.fragment_contact, container, false)
        binding = FragmentContactBinding.bind(view)


//        or you can directly inflate like this
//        binding = FragmentContactBinding.inflate(inflater, container, false)

        binding.apply {
            btnContact.setOnClickListener {
                val text = etContact.text.toString().trim()
                tvContact.text = text
                etContact.text?.clear()
                Toast.makeText(context, "text changed to $text", Toast.LENGTH_SHORT).show()
            }
        }


//       return the binding object
        return binding.root
    }
}