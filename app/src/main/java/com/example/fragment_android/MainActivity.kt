package com.example.fragment_android

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fragment_android.databinding.ActivityMainBinding
import com.example.fragment_android.fragments.FragmentA
import com.example.fragment_android.fragments.FragmentB
import kotlinx.android.synthetic.main.fragment_a.*

class MainActivity : AppCompatActivity() , Communicator
{
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*This check is used to avoid calling Fragment lifecycles twice
        * Check Reference 1 for more details
        *  */
        if (savedInstanceState == null)
        {
            val fragmentA = FragmentA()
            supportFragmentManager.beginTransaction().replace(R.id.fragmentMainContainer , fragmentA)
                .commit()
        }
    }

    override fun passData(editTextInput : String)
    {
        val bundle = Bundle().apply {
            putString("message" , editTextInput)
        }
        val fragmentB = FragmentB()
        fragmentB.arguments = bundle
        supportFragmentManager.beginTransaction().replace(R.id.fragmentMainContainer , fragmentB)
            .commit()
    }
}