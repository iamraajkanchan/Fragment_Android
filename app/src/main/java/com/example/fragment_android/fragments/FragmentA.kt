package com.example.fragment_android.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragment_android.Communicator
import com.example.fragment_android.R
import kotlinx.android.synthetic.main.fragment_a.*
import kotlinx.android.synthetic.main.fragment_a.view.*

class FragmentA : Fragment()
{
    private lateinit var communicator : Communicator
    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? , savedInstanceState : Bundle?
    ) : View?
    {
        communicator = activity as Communicator
        val view = inflater.inflate(R.layout.fragment_a , container , false)
        view.btnSend.setOnClickListener {
            communicator.passData(view.edtMessage.text.toString())
        }
        return view
    }

    override fun onStart()
    {
        super.onStart()
        tvActivityLabel.text = "MainActivity"
    }

}