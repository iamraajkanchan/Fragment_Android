package com.example.fragment_android.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragment_android.R
import kotlinx.android.synthetic.main.fragment_b.*
import kotlinx.android.synthetic.main.fragment_b.view.*

class FragmentB : Fragment()
{
    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? , savedInstanceState : Bundle?
    ) : View?
    {
        val view = inflater.inflate(R.layout.fragment_b , container , false)
        view.tvMessage.text = arguments?.getString("message")
        return view
    }

    override fun onActivityCreated(savedInstanceState : Bundle?)
    {
        super.onActivityCreated(savedInstanceState)
        tvActivityLabel.text = "MainActivity"
    }
}