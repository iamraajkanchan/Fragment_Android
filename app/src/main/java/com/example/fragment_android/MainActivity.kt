package com.example.fragment_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragment_android.databinding.ActivityMainBinding
import com.example.fragment_android.fragments.FragmentA
import com.example.fragment_android.fragments.FragmentB

class MainActivity : AppCompatActivity() , Communicator
{
    private lateinit var binding : ActivityMainBinding
    private var fragmentA : FragmentA? = null
    private var fragmentB : FragmentB? = null

    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)/*This check is used to avoid calling Fragment lifecycles twice
        * Check Reference 1 for more details
        *  */
        if (savedInstanceState == null)
        {
            fragmentA = FragmentA()
            supportFragmentManager.beginTransaction().add(R.id.fragmentMainContainer , fragmentA !!)
                .commit()
        }
    }

    override fun passData(editTextInput : String)
    {
        val bundle = Bundle().apply {
            putString("message" , editTextInput)
        }
        fragmentB = FragmentB()
        fragmentB?.arguments = bundle
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.hide(fragmentA !!)
        transaction.add(R.id.fragmentMainContainer , fragmentB !!).commit()
    }
}