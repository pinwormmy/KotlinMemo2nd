package com.eol.memo2nd

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.eol.memo2nd.databinding.ActivityMainBinding
import com.eol.memo2nd.databinding.Test1Binding

class display_test1 : AppCompatActivity() {

    lateinit var binding2 : Test1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test1)
        binding2 = Test1Binding.inflate(layoutInflater)

        val intent2 = Intent(this, ActivityMainBinding::class.java)

        binding2.toMainButton.setOnClickListener{

            startActivity(intent2)
        }
    }
}