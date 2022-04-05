package com.eol.memo2nd

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.eol.memo2nd.databinding.ActivityMainBinding
import com.eol.memo2nd.databinding.Test1Binding

class DisplayTest1 : AppCompatActivity() {

    lateinit var binding2 : Test1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2 = Test1Binding.inflate(layoutInflater)
        setContentView(binding2.root)


        binding2.toMainButton.setOnClickListener{

            finish()
        }
    }
}