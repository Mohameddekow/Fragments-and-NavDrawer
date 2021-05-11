package com.example.slidablemenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.slidablemenu.databinding.FragmentSettingBinding

class SettingFragment: Fragment() {
    lateinit var binding: FragmentSettingBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view =  inflater.inflate(R.layout.fragment_setting, container, false)
        binding = FragmentSettingBinding.bind(view)

        binding.apply {
            btnSetting.setOnClickListener {
                val text = etSetting.text.toString().trim()
                tvSetting.text = text

                etSetting.text?.clear()
                Toast.makeText(context, "text changed to $text", Toast.LENGTH_SHORT).show()
            }
        }


    return binding.root
    }
}