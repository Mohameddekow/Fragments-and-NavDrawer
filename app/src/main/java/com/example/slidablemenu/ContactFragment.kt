package com.example.slidablemenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ContactFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

         return inflater.inflate(R.layout.fragment_contact, null)

//        return super.onCreateView(inflater, container, savedInstanceState)
    }
}